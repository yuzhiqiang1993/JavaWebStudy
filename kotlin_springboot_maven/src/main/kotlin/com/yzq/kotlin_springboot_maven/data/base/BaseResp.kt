package com.yzq.kotlin_springboot_maven.data.base

import com.yzq.kotlin_springboot_maven.constants.RespEnum


/**
 * @description: 响应基类
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */
data class BaseResp<T>(
    var code: Int = RespEnum.SUCCESS.code,
    var data: T? = null,
    var message: String = RespEnum.SUCCESS.msg,
    var time: Long = 0L,
)