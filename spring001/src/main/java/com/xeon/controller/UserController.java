package com.xeon.controller;

import com.xeon.entity.User;
import com.xeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: Controller层
 * @date : 2021/9/4
 * @time : 14:19
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;


    public User getUserById(Integer id) {
        return userService.getUserById(id);

    }


}
