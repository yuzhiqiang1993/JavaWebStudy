package com.yzq.jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {

        try {
            /*1.加载MySql驱动*/
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            /*2建立连接*/
            String url = "jdbc:mysql://localhost:3306/xeon?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String pwd = "19930904";
            /*获取连接*/
            Connection connection = DriverManager.getConnection(url, user, pwd);

            /*获取Statement对象*/
            Statement statement = connection.createStatement();

            /*Sql语句*/
            String insertSql = "insert into user(name, age, gender, height, weight) values ('喻志强',28,'男',170,130);";


//            String updateSql="update user set name='yzq' where id=1";
//            String deleteSql = "delete from user where id=1";
            /*增删改都用executeUpdate 返回受影响的行数*/
            int count = statement.executeUpdate(insertSql);
            System.out.println("受影响的行数:" + count);

            /*查询数据*/
            String querySql = "select * from user";
            /*查询用executeQuery 返回的是一个结果集*/
            ResultSet resultSet = statement.executeQuery(querySql);
            /*循环取数据*/
            while (resultSet.next()) {
                /*根据列名取出数据*/
                int id = resultSet.getInt("id");
                System.out.println("id:" + id);
                String name = resultSet.getString("name");
                System.out.println("name:" + name);
            }

            /*释放资源 实际开发中一般是在 finally中去释放资源*/
            connection.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}
