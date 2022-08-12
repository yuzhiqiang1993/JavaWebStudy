package com.yzq.kotlin_springboot_maven.data.base


/**
 * @description: 分页请求
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2022/6/29
 * @time   : 18:47
 */
open class BasePageReq {
    val pageNum: Long = 1
    val pageSize: Long = 50

    open fun checkData() {
        if (pageNum < 1 || pageSize < 1) {
            throw Exception("参数异常")
        }

    }
}