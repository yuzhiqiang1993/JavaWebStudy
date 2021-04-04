package com.yzq.Integral_process_server.server;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.yzq.Integral_process_server.server.utils.DruidUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 更改密码 （更改数据库中的记录）
 * @date : 2021/4/4
 * @time : 17:09
 */
@WebServlet(name = "ChangePwdServlet", value = "/changePwd")
public class ChangePwdServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        System.out.println("account = " + account);
        String pwd = request.getParameter("pwd");
        System.out.println("pwd = " + pwd);

        try {
            DruidPooledConnection connection = DruidUtils.druidDataSource.getConnection();
            String sql = "update account set pwd=? where user_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, pwd);
            preparedStatement.setString(2, account);


            int i = preparedStatement.executeUpdate();

            System.out.println("i = " + i);

            if (i > 0) {
                response.getWriter().write("修改成功");
            } else {
                response.getWriter().write("修改失败");
            }

            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
