package com.xeon.springboot.service;

import com.xeon.springboot.dao.data.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    User getUser(int id);
}
