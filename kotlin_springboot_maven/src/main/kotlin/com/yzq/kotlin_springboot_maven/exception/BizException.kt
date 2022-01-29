package com.yzq.kotlin_springboot_maven.exception

import com.yzq.kotlin_springboot_maven.constants.RespEnum


/**
 * @description: 业务相关异常
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */
data class BizException(val code: Int = RespEnum.ERROR.code, override val message: String = RespEnum.ERROR.msg) :
    Exception(message)