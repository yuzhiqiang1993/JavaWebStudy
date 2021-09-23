package com.xeon.springboot_mp.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xeon.springboot_mp.dao.data.User;
import com.xeon.springboot_mp.dao.mapper.UserMapper;

import com.xeon.springboot_mp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
