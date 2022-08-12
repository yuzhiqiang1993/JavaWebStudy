package com.yzq.kotlin_springboot_maven.data.resp


/**
 * @description: 分页相关的返回数据
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2022/1/21
 * @time   : 11:26 AM
 */
data class PageResult<T>(
    var totalPage: Long = 0,//总页数
    var totalCount: Long = 0,//总条数
    var data: T? = null,//数据xxx

)