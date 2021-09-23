package com.xeon.springboot_mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xeon.springboot_mp.dao.data.User;
import org.springframework.stereotype.Service;


/*
 * 固定写法 继承自IService，提供了常用的增删改查方法
 * */
public interface UserService extends IService<User> {
}
