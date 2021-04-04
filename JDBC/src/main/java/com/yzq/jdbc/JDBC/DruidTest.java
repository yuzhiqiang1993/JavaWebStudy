package com.yzq.jdbc.JDBC;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 阿里 druid 测试
 * @date : 2021/4/4
 * @time : 11:36
 */
public class DruidTest {

    public static void main(String[] args) {
        /*创建 DruidDataSource 对象*/
        DruidDataSource druidDataSource = new DruidDataSource();
        /*配置数据库相关信息*/
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/xeon?useUnicode=true&characterEncoding=UTF-8");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("19930904");
        //配置
        druidDataSource.setInitialSize(5);  //初始连接数
        druidDataSource.setMaxActive(20);  //最大连接数
        druidDataSource.setMinIdle(10);  //最小闲置数
        druidDataSource.setMaxWait(6000);  //获取连接等待超时的时间
        druidDataSource.setMaxOpenPreparedStatements(10); //缓存PreparedStatement的最大数量
        try {
            DruidPooledConnection connection = druidDataSource.getConnection();
            String sql = "insert into account(user_name, pwd) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "喻志强");
            preparedStatement.setString(2, "19930904");
            int execute = preparedStatement.executeUpdate();
            /*这里的close 并不是真正的销毁  而是回收  具体可以去看下源码*/
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
