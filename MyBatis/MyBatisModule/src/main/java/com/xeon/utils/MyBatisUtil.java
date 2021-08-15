package com.xeon.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description:
 * @date : 2021/8/15
 * @time : 10:38
 */
public class MyBatisUtil {

    private MyBatisUtil() {

    }

    private static SqlSessionFactory sessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            /*获取Factory对象*/
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession() {

        return sessionFactory.openSession();

    }


}
