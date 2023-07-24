package com.yzq.common.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response


/**
 * @description: 自定义请求头
 * @author : yuzhiqiang
 * @date   : 2023/6/16
 * @time   : 13:50
 */

class RequestHeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {


        val request = chain.request()

        val builder = request.newBuilder()

        builder.addHeader("Authorization", "Bearer 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")
            .header("Accept", "*/*")
//            .header("Accept-Encoding", "gzip")
//            .header("Cache-Control", "no-cache")
            .build()

        return chain.proceed(builder.build())

    }


}
