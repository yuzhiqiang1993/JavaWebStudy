package com.xeon.springboot.dao;

import com.xeon.springboot.dao.data.User;

import java.util.List;


public interface UserMappper {
    List<User> listUsers();

    User getUser(Integer id);
}
