package com.yzq.kotlin_server.kotlinServer.servlet

import com.yzq.kotlin_server.kotlinServer.utils.DruidUtils
import java.lang.Exception
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @description: 注册接口 （对应数据库中的 增）
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/4/4
 * @time   : 20:30
 */

@WebServlet(name = "RegisterServlet", value = ["/register"])
class RegisterServlet : HttpServlet() {

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

        val account = request.getParameter("account")
        println("account = ${account}")
        val pwd = request.getParameter("pwd")
        println("pwd = ${pwd}")


        val sql = "insert into account(user_name,pwd) values(?,?)"


        try {
            val connection = DruidUtils.druidDataSource.getConnection()
            val prepareStatement = connection.prepareStatement(sql)
            prepareStatement.setString(1, account)
            prepareStatement.setString(2, pwd)

            val executeUpdate = prepareStatement.executeUpdate()

            println("executeUpdate = ${executeUpdate}")

            connection.close()

            if (executeUpdate > 0) {
                response.writer.write("注册成功")
            } else {
                response.writer.write("注册失败")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            response.writer.write("注册失败")
        } finally {


        }


    }
}