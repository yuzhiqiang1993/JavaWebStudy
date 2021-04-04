package com.yzq.kotlin_server.kotlinServer.servlet

import com.yzq.kotlin_server.kotlinServer.utils.DruidUtils
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @description: 修改密码 对应数据库中的 改
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/4/4
 * @time   : 20:49
 */
@WebServlet(name = "ChangePwdServlet", value = ["/changePwd"])
class ChangePwdServlet : HttpServlet() {

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

        val account = request.getParameter("account")
        println("account = ${account}")
        val pwd = request.getParameter("pwd")
        println("pwd = ${pwd}")


        val sql = "update account set pwd=?  where user_name=?"

        try {

            val connection = DruidUtils.druidDataSource.getConnection()
            val prepareStatement = connection.prepareStatement(sql)
            prepareStatement.setString(1, pwd)
            prepareStatement.setString(2, account)

            val executeUpdate = prepareStatement.executeUpdate()

            if (executeUpdate > 0) {
                response.writer.write("密码修改成功")
            } else {
                response.writer.write("密码修改失败")
            }

            connection.close()
        } catch (e: Exception) {
            e.printStackTrace()
            response.writer.write("密码修改失败")
        } finally {

        }


    }
}