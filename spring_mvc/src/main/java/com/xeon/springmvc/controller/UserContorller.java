package com.xeon.springmvc.controller;


import com.google.gson.Gson;
import com.xeon.springmvc.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContorller {

    @RequestMapping(value = "user", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String getUser(String id) {
        /*参数可以直接拿到  get和post 表单形式的都支持*/
        System.out.println("user 执行了");

        System.out.println("id = " + id);
        final User user = new User();

        user.setAge(28);
        user.setName("喻志强");
        return new Gson().toJson(user);

    }


    /**
     * 这种会把 表单 传的参数自动封成user对象
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user1", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String getUser1(User user) {


        System.out.println("user = " + user);

        return new Gson().toJson(user);

    }

    /**
     * 这种会把 表单 传的参数自动封成user对象
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "userByJson", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String getUserByJson(@RequestBody User user) {


        System.out.println("getUserByJson user = " + user);

        return new Gson().toJson(user);

    }

}
