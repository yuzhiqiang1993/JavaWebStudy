package com.yzq.kotlin_server.kotlinServer.servlet

import com.yzq.kotlin_server.kotlinServer.utils.DruidUtils
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @description: 注册接口 （对应数据库中的 查）
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/4/4
 * @time   : 20:41
 */
@WebServlet(name = "LoginServlet", value = ["/login"])
class LoginServlet : HttpServlet() {


    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

        val account = request.getParameter("account")
        println("account = ${account}")
        val pwd = request.getParameter("pwd")
        println("pwd = ${pwd}")


        val sql = "select * from  account where user_name=? and pwd=?"

        try {

            val connection = DruidUtils.druidDataSource.getConnection()
            val prepareStatement = connection.prepareStatement(sql)
            prepareStatement.setString(1, account)
            prepareStatement.setString(2, pwd)

            val executeQuery = prepareStatement.executeQuery()



            if (executeQuery.next()) {
                response.writer.write("登录成功")
            } else {
                response.writer.write("登录失败")
            }

            connection.close()
        } catch (e: Exception) {
            e.printStackTrace()
            response.writer.write("登录失败")
        } finally {

        }

    }
}