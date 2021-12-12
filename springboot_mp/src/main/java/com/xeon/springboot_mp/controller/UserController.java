package com.xeon.springboot_mp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xeon.springboot_mp.dao.User;
import com.xeon.springboot_mp.data.request.KeyWord;
import com.xeon.springboot_mp.data.request.RequestPage;
import com.xeon.springboot_mp.data.resp.BaseResp;
import com.xeon.springboot_mp.data.resp.RespPageUser;
import com.xeon.springboot_mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping("/list")
    @ResponseBody
    List<User> getUserList() {


        final List<User> list = userService.list();

        System.out.println("list = " + list);

        return list;
    }

    @GetMapping("/getUserById")
    @ResponseBody
    User getUserById(Integer userId) {

        final User user = userService.getById(userId);

        System.out.println("user = " + user);

        return user;
    }


    @PostMapping(value = "/getUserLikeName")
    @ResponseBody
    List<User> getUserLikeName(@RequestBody KeyWord keyWord) {

        System.out.println("接收的参数:" + keyWord);
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.like("name", keyWord.getKeyWord());

        return userService.list(userQueryWrapper);

    }


    @PostMapping("/getUsers")
    @ResponseBody
    BaseResp<RespPageUser> getUserList(@RequestBody RequestPage requestPage) {

        final BaseResp<RespPageUser> listBaseResp = new BaseResp<>();

        final Page<User> userPage = new Page<>();

        userPage.setCurrent(requestPage.getPageNum());
        userPage.setSize(requestPage.getPageSize());

        System.out.println("userPage.getSize() = " + userPage.getSize());
        System.out.println("userPage.getCurrent() = " + userPage.getCurrent());

        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("enable", 1);

        final Page<User> page = userService.page(userPage, userQueryWrapper);


        final RespPageUser respPageUser = new RespPageUser();
        respPageUser.setTotal(page.getTotal());
        respPageUser.setUserList(page.getRecords());

        listBaseResp.setData(respPageUser);
        listBaseResp.setStatus(200);
        listBaseResp.setMessage("请求成功");


        return listBaseResp;

    }


}
