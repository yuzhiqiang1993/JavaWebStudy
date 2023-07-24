package com.yzq.kotlinspringbootkts.service

import com.yzq.common.net.RetrofitFactory
import com.yzq.kotlinspringbootkts.data.request.ReqEmbeding
import com.yzq.kotlinspringbootkts.net.ApiService
import org.springframework.stereotype.Service

@Service
class OpenAiService {

    suspend fun embedding(content: String): List<Float> {

        val respEnbeding = RetrofitFactory.instance.getService(ApiService::class.java)
            .embeddings(ReqEmbeding(content))

        return respEnbeding.data[0].embedding


    }


}
