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
 * @description: 注册  (往数据库增加一条数据)
 * @date : 2021/4/4
 * @time : 14:28
 */
@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        System.out.println("account = " + account);
        String pwd = request.getParameter("pwd");
        System.out.println("pwd = " + pwd);


        /*插入到数据库*/

        try {
            DruidPooledConnection connection = DruidUtils.druidDataSource.getConnection();
            String sql = "insert into account(user_name,pwd) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, pwd);

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                response.getWriter().write("成功");
            } else {
                response.getWriter().write("失败");
            }
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
