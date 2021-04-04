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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 登录  （查数据）
 * @date : 2021/4/4
 * @time : 17:01
 */

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String account = req.getParameter("account");
        System.out.println("account = " + account);

        String pwd = req.getParameter("pwd");
        System.out.println("pwd = " + pwd);


        try {
            DruidPooledConnection connection = DruidUtils.druidDataSource.getConnection();

            String sql = "select * from account where user_name=? and pwd=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                /*说明账号和密码正确*/

                resp.getWriter().write("登录成功");
            } else {
                resp.getWriter().write("登录失败");
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
