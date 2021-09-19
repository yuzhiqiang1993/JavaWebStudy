package com.xeon.service;

import com.xeon.dao.data.User;
import com.xeon.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUserviceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override

    public List<User> listUser() {


        return userMapper.listUser();
    }
}
