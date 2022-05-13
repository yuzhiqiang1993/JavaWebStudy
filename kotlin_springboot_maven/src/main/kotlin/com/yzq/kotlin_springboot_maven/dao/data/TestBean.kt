package com.yzq.kotlin_springboot_maven.dao.data

import com.fasterxml.jackson.annotation.JsonProperty


/**
 * @description: 属性名大小写
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2022/5/13
 * @time   : 15:31
 */
data class TestBean(
    val name: String = "",
    val age: Int = 0,
    @get:JsonProperty("AVN")
    val AVN: String = "",
    @get:JsonProperty("MallVersion")
    val MallVersion: String = "test",
)