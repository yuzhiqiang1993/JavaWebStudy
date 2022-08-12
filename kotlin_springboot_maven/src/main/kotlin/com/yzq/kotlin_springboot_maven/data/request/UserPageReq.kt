package com.yzq.kotlin_springboot_maven.data.request

import com.yzq.kotlin_springboot_maven.data.base.BasePageReq


/**
 * @description: 分页查询
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2022/8/12
 * @time   : 18:30
 */
data class UserPageReq(
    val searchKey: String = "",
) : BasePageReq()