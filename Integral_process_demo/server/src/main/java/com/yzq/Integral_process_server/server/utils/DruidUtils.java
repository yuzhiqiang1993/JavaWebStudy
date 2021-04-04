package com.yzq.Integral_process_server.server.utils;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidUtils {

    public static final DruidDataSource druidDataSource;

    static {
        /*创建 DruidDataSource 对象*/
        druidDataSource = new DruidDataSource();
        /*配置数据库相关信息*/
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/xeon?useUnicode=true&characterEncoding=UTF-8");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("19930904");//这个密码改成你自己的数据库的密码

    }

}
