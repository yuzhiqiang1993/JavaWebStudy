package com.yzq.kotlinspringbootkts

import io.milvus.client.MilvusServiceClient
import io.milvus.param.ConnectParam

object MilvusManager {

    /*连接数据库*/
    val milvusServiceClient by lazy {
        val connectParam = ConnectParam.newBuilder().withHost("47.101.162.134").withPort(19530).build()
        MilvusServiceClient(connectParam)
    }
}
