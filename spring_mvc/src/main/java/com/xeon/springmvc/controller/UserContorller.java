package com.xeon.springmvc.controller;


import com.google.gson.Gson;
import com.xeon.springmvc.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserContorller {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(HttpServletResponse response) {

        response.setContentType("application/json;charset=UTF-8");
        System.out.println("user 执行了");

        final User user = new User();

        user.setAge(28);
        user.setName("喻志强");
        return new Gson().toJson(user);

    }

}
