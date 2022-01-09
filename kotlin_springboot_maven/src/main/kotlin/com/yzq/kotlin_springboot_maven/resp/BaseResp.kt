package com.yzq.kotlin_springboot_maven.data.resp

import com.yzq.kotlin_springboot_maven.constants.RespEnum


/**
 * @description: 响应基类
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */
data class BaseResp<T>(
    var code: Int = RespEnum.SUCCESS.code,
    var data: T? = null,
    var message: String = RespEnum.SUCCESS.msg,
) {
    fun error(error: RespEnum) {
        this.code = error.code
        this.message = error.msg
    }
}