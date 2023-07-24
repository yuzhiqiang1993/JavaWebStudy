package com.yzq.kotlinspringbootkts.net

import com.yzq.kotlinspringbootkts.data.request.ReqEmbeding
import com.yzq.kotlinspringbootkts.data.resp.RespEnbeding
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {


    @POST("v1/embeddings")
    suspend fun embeddings(@Body body: ReqEmbeding): RespEnbeding

}
