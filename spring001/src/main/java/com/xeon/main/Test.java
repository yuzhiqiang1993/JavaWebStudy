package com.xeon.main;

import com.xeon.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        /*传统方式创建对象*/
        final User user = new User();

        user.setId(1);
        user.setAge(18);
        user.setName("Xeon");

        System.out.println("user = " + user);


        /*IOC 方式*/
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        final Object user1 = applicationContext.getBean("user");

        System.out.println("user1 = " + user1);
    }
}
