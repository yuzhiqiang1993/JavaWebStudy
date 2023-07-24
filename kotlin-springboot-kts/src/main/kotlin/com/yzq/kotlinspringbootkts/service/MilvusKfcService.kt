package com.yzq.kotlinspringbootkts.service

import com.yzq.kotlinspringbootkts.MilvusManager
import io.milvus.common.clientenum.ConsistencyLevelEnum
import io.milvus.grpc.DataType
import io.milvus.grpc.MutationResult
import io.milvus.grpc.SearchResults
import io.milvus.param.*
import io.milvus.param.collection.CreateCollectionParam
import io.milvus.param.collection.FieldType
import io.milvus.param.collection.LoadCollectionParam
import io.milvus.param.dml.InsertParam
import io.milvus.param.dml.SearchParam
import io.milvus.param.index.CreateIndexParam
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.random.Random

@Service
class MilvusKfcService {


    private val collectName = "kfc_menu"
    private val dishId = "id"
    private val dishName = "name"
    private val price = "price"

    private val dishType = "dish_type"
    private val tag = "tag"
    private val vector = "vector"


    private val milvusServiceClient = MilvusManager.milvusServiceClient

    @Autowired
    private lateinit var openAiService: OpenAiService

    fun createCollection(): R<RpcStatus>? {
        /**
         * 创建集合必须要包含一个主键字段和向量字段
         * 向量字段必须要有索引，否则无法正常load数据
         */

        /*filed相当于表的字段*/
        val dishId = FieldType.newBuilder().withName(dishId)
            .withDataType(DataType.Int64)
            .withPrimaryKey(true)
            .withAutoID(true)
            .build()
        val dishName: FieldType = FieldType.newBuilder()
            .withName(dishName)
            .withDataType(DataType.VarChar)
            .withMaxLength(20)
            .build()
        val dishPrice: FieldType = FieldType.newBuilder()
            .withName(price)
            .withDataType(DataType.Float)
            .build()
        val dishType: FieldType = FieldType.newBuilder()
            .withName(dishType)
            .withDataType(DataType.VarChar)
            .withMaxLength(20)
            .build()

        val tag = FieldType.newBuilder()
            .withName(tag)
            .withDataType(DataType.VarChar)
            .withMaxLength(5000)
            .build()


        val vector = FieldType.newBuilder()
            .withName(vector)
            .withDataType(DataType.FloatVector)
            .withDimension(1536)//向量的维度
            .build()


        /*collection 相当于表*/
        val createCollectionReq = CreateCollectionParam.newBuilder()
            .withCollectionName(collectName)
            .withDescription("kfc菜单")
            .withShardsNum(2)
//            .withDatabaseName("kfc")
            .addFieldType(dishId)
            .addFieldType(dishName)
            .addFieldType(dishType)
            .addFieldType(dishPrice)
            .addFieldType(tag)
            .addFieldType(vector)
            .withEnableDynamicField(true)
            .build()


        /*创建集合*/
        val createCollection = MilvusManager.milvusServiceClient.createCollection(createCollectionReq)
        println("createCollection = ${createCollection}")

        return createCollection

    }

    fun createIndex(): R<RpcStatus> {

        /**
         * withIndexType
         * INVALID: 无效的索引类型。
         * FLAT: Flat 索引类型，适用于小规模的数据集。
         * IVF_FLAT: Inverted File（倒排文件）Flat 索引类型，适用于大规模的数据集。
         * IVF_SQ8: Inverted File（倒排文件）SQ8 索引类型，适用于大规模的数据集。
         * IVF_PQ: Inverted File（倒排文件）PQ 索引类型，适用于大规模的数据集。
         * HNSW: Hierarchical Navigable Small World（层次导航小世界）索引类型，适用于高维向量数据。
         * ANNOY: ANNOY（近邻搜索库）索引类型，适用于近邻搜索。
         * RHNSW_FLAT: Randomized Hierarchical Navigable Small World（随机层次导航小世界）Flat 索引类型，适用于高维向量数据。
         * RHNSW_PQ: Randomized Hierarchical Navigable Small World（随机层次导航小世界）PQ 索引类型，适用于高维向量数据。
         * RHNSW_SQ: Randomized Hierarchical Navigable Small World（随机层次导航小世界）SQ 索引类型，适用于高维向量数据。
         * DISKANN: DiskANN（基于磁盘存储的近邻搜索库）索引类型，适用于大规模数据集和高维向量。
         * AUTOINDEX: 自动选择索引类型，Milvus 会根据数据集的规模和特征自动选择合适的索引类型。
         * BIN_FLAT: 二进制向量的 Flat 索引类型。
         * BIN_IVF_FLAT: 二进制向量的 Inverted File（倒排文件）Flat 索引类型。
         * TRIE: 用于 varchar 类型字段的 Trie（字典树）索引类型。
         */

        /**
         * MetricType
         * INVALID: 无效的度量类型。
         * L2: L2 距离（欧氏距离），适用于浮点数向量。
         * IP: 内积距离，适用于浮点数向量。
         * HAMMING: 汉明距离，适用于二进制向量。
         * JACCARD: Jaccard 距离，适用于二进制向量。
         * TANIMOTO: Tanimoto 距离，适用于二进制向量。
         * SUBSTRUCTURE: 子结构距离，适用于图像、化学分子等具有子结构特征的向量。
         * SUPERSTRUCTURE: 超结构距离，适用于图像、化学分子等具有超结构特征的向量。
         */


        val extParam = """
           {
  "index_type": "IVF_FLAT",
  "metric_type": "L2",
  "params": "{\"nlist\":\"2\"}"
}
        """.trimIndent()

        val indexParam = CreateIndexParam.newBuilder()
            .withCollectionName(collectName)
            .withIndexName(vector)
            .withFieldName(vector)
            .withIndexType(IndexType.IVF_FLAT)
            .withMetricType(MetricType.L2)
            .withSyncMode(false)
//            .withExtraParam(extParam)
            .build()

        val createIndex = MilvusManager.milvusServiceClient.createIndex(indexParam)
        return createIndex
    }

    suspend fun insertData(): R<MutationResult> {


        /*生成数据*/
//        val dishIdList: MutableList<Long> = ArrayList()
        val dishNameList: MutableList<String> = ArrayList()
        val priceList: MutableList<Float> = ArrayList()
        val dishTypeList: MutableList<String> = ArrayList()
        val tagList: MutableList<String> = ArrayList()
        val vectorList: MutableList<List<Float>> = ArrayList()



        dishNameList.add("可乐")
        val randomPrice = Random.nextDouble(5.0, 30.0)
        priceList.add(randomPrice.toFloat())
        dishTypeList.add("饮料")
        tagList.add("喝,水,渴")

        /*生成向量*/
        val text1 = "${dishNameList.get(0)},${dishTypeList.get(0)},${tagList.get(0)}"


        val embedding1 = openAiService.embedding(text1)
        println("embedding1 = ${embedding1}")
        vectorList.add(embedding1)

        dishNameList.add("汉堡")
        val randomPrice1 = Random.nextDouble(5.0, 30.0)
        priceList.add(randomPrice1.toFloat())
        dishTypeList.add("食物")
        tagList.add("饿,肉,吃")

        val text2 = "${dishNameList.get(1)},${dishTypeList.get(1)},${tagList.get(1)}"


        val embedding2 = openAiService.embedding(text2)
        println("embedding2 = ${embedding2}")
        vectorList.add(embedding2)

//        for (i in 1L..5) {
//
////            dishIdList.add(i)
//            val name = "汉堡${i}"
//            dishNameList.add(name)
//            val randomPrice = Random.nextDouble(5.0, 30.0)
//            priceList.add(randomPrice.toFloat())
//            val type = "汉堡类"
//            dishTypeList.add("汉堡类")
//            val tag = "饿,汉堡，辣，热"
//            tagList.add(tag)
//
//
//            /*生成向量*/
//            val text = "${name},${type},${tag}"
//
//
//            val embedding = openAiService.embedding(text)
//            println("embedding = ${embedding}")
//            vectorList.add(embedding)
//
//        }


        /*插入数据*/
        val fields: MutableList<InsertParam.Field> = ArrayList()
//        fields.add(InsertParam.Field(dishId, dishIdList))
        fields.add(InsertParam.Field(dishName, dishNameList))
        fields.add(InsertParam.Field(dishType, dishTypeList))
        fields.add(InsertParam.Field(price, priceList))
        fields.add(InsertParam.Field(tag, tagList))
        fields.add(InsertParam.Field(vector, vectorList))

        val insertParam = InsertParam.newBuilder()
            .withCollectionName(collectName)
            .withPartitionName("_default")
            .withFields(fields)
            .build()

        val insertResult = milvusServiceClient.insert(insertParam)


        println("insertResult = ${insertResult}")

        return insertResult


    }

    fun search(vectorVal: List<Float>): R<SearchResults> {
        println("vectorVal = ${vectorVal is List<Float>}")


        val lists = arrayListOf<List<Float>>(vectorVal)
        val searchParam = SearchParam.newBuilder()
            .withCollectionName(collectName)
            .withConsistencyLevel(ConsistencyLevelEnum.STRONG)
            .withVectors(lists)
            .withVectorFieldName(vector)
            .withTopK(3)
            .addOutField(dishId)
            .addOutField(dishName)
            .addOutField(price)
            .withMetricType(MetricType.L2)
            .build()


        return milvusServiceClient.search(searchParam)

    }

    private var loaded = AtomicBoolean(false)
    fun loadToMemory(): String {

        if (loaded.get()) {
            return "已经加载过了"
        }

        val loadCollectionParam = LoadCollectionParam.newBuilder()
            .withCollectionName(collectName)
            .build()
        val loadCollection = milvusServiceClient.loadCollection(loadCollectionParam)

        return if (loadCollection.status == R.Status.Success.code) {
            loaded.set(true)
            loadCollection.data.msg
        } else {
            loaded.set(false)
            loadCollection.exception.printStackTrace()
            loadCollection.exception.localizedMessage
        }

    }

}
