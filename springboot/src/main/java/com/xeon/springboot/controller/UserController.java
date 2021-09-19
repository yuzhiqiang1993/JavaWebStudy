package com.xeon.springboot.controller;


import com.xeon.springboot.dao.UserMappper;
import com.xeon.springboot.dao.data.User;
import com.xeon.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/listUsers", method = {RequestMethod.GET})
    @ResponseBody
    public List<User> listUsers() {
        final List<User> users = userService.listUsers();

        System.out.println("users = " + users);


        return users;

    }


    @RequestMapping("/getUser")
    @ResponseBody
    public User getUserById(int id){
        return userService.getUser(id);
    }

}
