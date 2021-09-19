package com.xeon.springboot.service.impl;

import com.xeon.springboot.dao.UserMappper;
import com.xeon.springboot.dao.data.User;
import com.xeon.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("UserService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMappper userMappper;

    @Override
    public List<User> listUsers() {

        final List<User> users = userMappper.listUsers();
        return users;
    }

    @Override
    public User getUser(int id) {
        return userMappper.getUser(id);
    }
}
