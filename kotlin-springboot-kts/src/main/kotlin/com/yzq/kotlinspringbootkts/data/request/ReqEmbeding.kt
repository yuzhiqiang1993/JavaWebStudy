package com.yzq.kotlinspringbootkts.data.request

data class ReqEmbeding(
    val input: String,
    val model: String = "text-embedding-ada-002"
)
