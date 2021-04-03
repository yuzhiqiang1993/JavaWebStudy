package com.yzq.jdbc.JDBC;

import com.yzq.jdbc.JDBC.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementTest {

    public static void main(String[] args) {
        try {
            /*获取连接*/
            Connection connection = JDBCUtil.getConnection();
            /*占位符Sql  ?就占位符*/
            String sql = "select * from account where user_name=? and pwd=?";
            /*获取PreparedStatement*/
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            /*按照顺序给占位符赋值*/
            preparedStatement.setString(1, "yuzhiqiang");
            preparedStatement.setString(2, "123456");
            /*执行查询*/
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登录失败");
            }
            /*释放资源*/
            JDBCUtil.close(connection, preparedStatement, resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
