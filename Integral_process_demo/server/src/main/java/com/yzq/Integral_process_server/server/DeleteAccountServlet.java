package com.yzq.Integral_process_server.server;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.yzq.Integral_process_server.server.utils.DruidUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 注销账号 （删）
 * @date : 2021/4/4
 * @time : 17:16
 */
@WebServlet(name = "DeleteAccountServlet", value = "/deleteAccount")
public class DeleteAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        System.out.println("account = " + account);
        String pwd = request.getParameter("pwd");
        System.out.println("pwd = " + pwd);

        try {
            DruidPooledConnection connection = DruidUtils.druidDataSource.getConnection();
            String sql = "delete from account where user_name=? and pwd=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account);
            preparedStatement.setString(2, pwd);

            int i = preparedStatement.executeUpdate();
            System.out.println("i = " + i);

            if (i > 0) {
                response.getWriter().write("删除成功");

            } else {
                response.getWriter().write("删除失败");

            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
