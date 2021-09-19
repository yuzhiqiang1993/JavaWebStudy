package com.xeon.controller;


import com.google.gson.Gson;
import com.xeon.dao.data.User;
import com.xeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: UserController
 * @date : 2021/9/19
 * @time : 11:54
 */
@Controller()
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/listUser")
    @ResponseBody
    public String listUser() {

        final List<User> users = userService.listUser();

        System.out.println("users = " + users);
        return new Gson().toJson(users);
    }
}
