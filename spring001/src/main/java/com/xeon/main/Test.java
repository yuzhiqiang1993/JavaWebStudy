package com.xeon.main;

import com.xeon.controller.UserController;
import com.xeon.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.xeon");

        /*获取controller controller里的东西会根据注解自动注入*/
        final UserController userController = applicationContext.getBean("userController", UserController.class);

        final User userById = userController.getUserById(1);

        System.out.println("userById = " + userById);

    }
}
