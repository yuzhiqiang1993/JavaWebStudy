package com.yzq.jdbc.JDBC.utils;


import java.sql.*;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: JDBC工具类
 * @date : 2021/4/3
 * @time : 17:56
 */
public class JDBCUtil {

    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/xeon";
    private static final String user = "root";
    private static final String pwd = "19930904";

    static {
        /*驱动只需要加载一次即可*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        /*获取 Connection*/
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;

    }


    /**
     * 释放资源
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
