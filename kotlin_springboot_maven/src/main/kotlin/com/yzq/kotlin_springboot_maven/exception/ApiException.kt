package com.yzq.kotlin_springboot_maven.exception


/**
 * @description: 接口相关的异常
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */
data class ApiException(val code: Int, override val message: String) : Exception(message)