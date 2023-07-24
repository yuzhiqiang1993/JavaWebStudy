package com.yzq.kotlinspringbootkts.controller

import com.yzq.kotlinspringbootkts.MilvusManager
import com.yzq.kotlinspringbootkts.service.MilvusKfcService
import com.yzq.kotlinspringbootkts.service.OpenAiService
import io.milvus.param.R
import io.milvus.param.collection.*
import io.milvus.param.partition.CreatePartitionParam
import io.milvus.response.SearchResultsWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/milvus")
class MilvusController {


    @Autowired
    private lateinit var milvusKfcService: MilvusKfcService

    @Autowired
    private lateinit var openApiService: OpenAiService


    @GetMapping("/createCollection")
    fun createCollection(): String? {


        val createCollection = milvusKfcService.createCollection()

        if (createCollection?.status == 0) {
            return createCollection.data.msg
        }

        return createCollection?.exception?.localizedMessage


    }


    @GetMapping("/listCollection")
    fun listCollection(): List<String> {
        val collections = MilvusManager.milvusServiceClient.showCollections(
            ShowCollectionsParam.newBuilder().build()
        )

        println("已有集合 collections = ${collections}")

        return collections.data.collectionNamesList.toList()

    }


    /*创建分区*/
    @GetMapping("/createPartition")
    fun GetMapping(@RequestParam("name") name: String): String? {
        /**
         * 可以将大量数据划分为少量分区，将搜索和其他操作限定在一个分区内以提高性能
         * 在创建集合时默认会创建一个_default分区
         * */
        val partitionParam = CreatePartitionParam.newBuilder()
            .withCollectionName("book")
            .withPartitionName("beverage").build()
        val createPartition = MilvusManager.milvusServiceClient.createPartition(partitionParam)
        println("createPartition = ${createPartition}")

        return createPartition.data.msg

    }


    @GetMapping("/createIndex")
    fun createIndex(): String? {

        val createIndex = milvusKfcService.createIndex()

        return if (createIndex.status == R.Status.Success.code) {
            createIndex.data.msg
        } else {
            createIndex.exception.localizedMessage
        }

    }


    @GetMapping("/insertData")
    suspend fun insertData(): String {


        val insertResult = milvusKfcService.insertData()

        if (insertResult.status == 0) {
            return "数据插入完成：${insertResult.data.succIndexCount}"
        }
        return insertResult.exception.localizedMessage

    }

//    private fun getVector(text: String) {
//
//
//        val build = Word2Vec.Builder()
//            .minWordFrequency(5)
//            .iterations(1)
//            .layerSize(100)
//            .seed(42)
//            .windowSize(5)
//            .build()
//
//        /*生成向量需要有模型...*/
//        val wordVectors = WordVectorSerializer.loadStaticModel(File(""))
//        DefaultTokenizerFactory().create(text)
//        //            val wordVector = build.getWordVector(word)
//        //            println("生成的向量：${wordVector}")
//        //            vectorList.add(wordVector)
//
//
//        return
//    }


    @GetMapping("/loadCollection")
    fun loadToMemory(): String {
        return milvusKfcService.loadToMemory()
    }

    @GetMapping("/search")
    suspend fun search(
        @RequestParam content: String
    ) {

        /*现将内容转成向量*/
        val embedding = openApiService.embedding(content)
        println("embedding = ${embedding}")
        val searchResultsR = milvusKfcService.search(embedding)
        println("searchResultsR = ${searchResultsR}")
        if (searchResultsR.status == R.Status.Success.code) {

            val searchResultsWrapper = SearchResultsWrapper(searchResultsR.data.results)

            println("searchResultsWrapper = ${searchResultsWrapper.getFieldData("name", 0)}")
            println("searchResultsWrapper = ${searchResultsWrapper.getFieldData("price", 0)}")
//            return searchResultsR.data.results
        } else {
            searchResultsR.exception.printStackTrace()
        }

//        return searchResultsR.data.results

    }

    @GetMapping("/deleteCollection")
    fun deleterCollection(@RequestParam("name") name: String): String? {
        val collectionParam = DropCollectionParam.newBuilder().withCollectionName(name).build()

        val dropCollection = MilvusManager.milvusServiceClient.dropCollection(collectionParam)

        return dropCollection.data.msg
    }
}
