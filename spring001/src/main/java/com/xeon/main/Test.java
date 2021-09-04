package com.xeon.main;

import com.xeon.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        /*传统方式创建对象*/
        final User user = new User();

        user.setId(1);
        user.setAge(18);
        user.setName("Xeon");

        System.out.println("user = " + user);


        /*IOC XML方式*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        final Object user1 = applicationContext.getBean("user");

        System.out.println("user1 = " + user1);


        /*注解方式*/
        final AnnotationConfigApplicationContext annotationIoc = new AnnotationConfigApplicationContext("com/xeon/entity");

        final Object user2 = annotationIoc.getBean("user");

        System.out.println("user2 = " + user2);
    }
}
