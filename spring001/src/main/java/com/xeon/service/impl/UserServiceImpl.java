package com.xeon.service.impl;

import com.xeon.dao.UserDao;
import com.xeon.entity.User;
import com.xeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: UserService实现类
 * @date : 2021/9/4
 * @time : 14:21
 */

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    UserDao userDao;


    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
