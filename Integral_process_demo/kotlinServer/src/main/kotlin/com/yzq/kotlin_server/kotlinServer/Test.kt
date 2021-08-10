package com.yzq.kotlin_server.kotlinServer

import com.yzq.kotlin_server.kotlinServer.utils.DruidUtils

class Test {
}

fun main() {

    /*模拟sql注入*/
    val connection = DruidUtils.druidDataSource.getConnection()
    val sql = "select * from account where user_name='喻志强' or 1=1"
    val prepareStatement = connection.prepareStatement(sql)

    val executeQuery = prepareStatement.executeQuery()

    while (executeQuery.next()) {
        println(executeQuery.getString(1))
    }


}