package com.yzq.kotlin_springboot_maven.constants


/**
 * @description: 响应枚举
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */
enum class RespEnum(val code: Int, val msg: String) {

    SUCCESS(200, "请求成功"),
    ERROR(-1, "请求异常"),
    NO_PERMISSION(-2, "没有权限"),
    PARAMETER_ERROR(-3, "参数异常")


}