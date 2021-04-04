package com.yzq.kotlin_server.kotlinServer.utils

import com.alibaba.druid.pool.DruidDataSource


/**
 * @description: 数据库链接池工具类
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/4/4
 * @time   : 20:53
 */
object DruidUtils {

    val druidDataSource: DruidDataSource

    init {
        /*创建 DruidDataSource 对象*/
        druidDataSource = DruidDataSource()

        /*配置数据库相关信息*/
        druidDataSource.url = "jdbc:mysql://localhost:3306/xeon?useUnicode=true&characterEncoding=UTF-8"
        druidDataSource.driverClassName = "com.mysql.cj.jdbc.Driver"
        druidDataSource.username = "root"
        druidDataSource.password = "19930904" //这个密码改成你自己的数据库的密码


    }

}