package com.xeon.dao;

import com.xeon.pojo.User;

import java.util.List;

public interface UserDaoMapper {

    List<User> getUsers();

    User getUser();
}
