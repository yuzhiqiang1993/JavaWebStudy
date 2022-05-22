package com.xeon.redis.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


/**
 * @description: jackson Util
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2022/5/22
 * @time   : 9:09
 */
object JacksonUtil {

    val jacksonMapper = jacksonObjectMapper()


    fun <T> toJson(src: T): String {
        return jacksonMapper.writeValueAsString(src)
    }

    inline fun <reified T> fromJson(jsonStr: String): T {
        return jacksonMapper.readValue<T>(jsonStr)
    }

}