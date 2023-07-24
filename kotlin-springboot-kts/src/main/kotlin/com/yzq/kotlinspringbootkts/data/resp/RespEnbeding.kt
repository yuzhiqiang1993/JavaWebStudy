package com.yzq.kotlinspringbootkts.data.resp


import com.fasterxml.jackson.annotation.JsonProperty

data class RespEnbeding(
    val `data`: List<Data>,
    val model: String, // text-embedding-ada-002-v2
    @JsonProperty("object")
    val objectX: String, // list
    val usage: Usage
) {
    data class Data(
        val embedding: List<Float>,
        val index: Int, // 0
        @JsonProperty("object")
        val objectX: String // embedding
    )

    data class Usage(
        @JsonProperty("prompt_tokens")
        val promptTokens: Int, // 8
        @JsonProperty("total_tokens")
        val totalTokens: Int // 8
    )
}
