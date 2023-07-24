package com.yzq.common.net

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.yzq.common.net.interceptor.RequestHeadersInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @description: RetrofitFactory
 * @author : yzq
 * @date   : 2018/7/9
 * @time   : 16:44
 *
 */

class RetrofitFactory private constructor() {

    private val retrofit: Retrofit

    private val loggingInterceptor = HttpLoggingInterceptor { message ->
        println(message) // 将请求日志打印到控制台
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY // 设置日志级别
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.openai.com/")
            .client(initOkhttpClient())
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
            .build()
    }

    /*线程安全的懒汉式单例*/
    companion object {
        val instance: RetrofitFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()
        }

    }

    private fun initOkhttpClient(): OkHttpClient {

        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(RequestHeadersInterceptor())
            .addInterceptor(loggingInterceptor)


//            .addInterceptor(ResponseDecryptInterceptor())


        return okHttpBuilder.build()
    }


    /*
    * 具体服务实例化
    * */
    fun <T> getService(service: Class<T>): T {

        return retrofit.create(service)
    }
}



