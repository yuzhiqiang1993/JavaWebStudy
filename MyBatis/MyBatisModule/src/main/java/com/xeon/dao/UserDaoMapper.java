package com.xeon.dao;

import com.xeon.pojo.User;

import java.util.List;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: UserMapper
 * @date : 2021/8/15
 * @time : 14:15
 */
public interface UserDaoMapper {

    /*这个里面的方法对饮 UserMapper 中的id*/

    /*获取全部用户*/
    List<User> getUsers();

    /*根据id查用户*/
    User getUserById(int id);

    /*新增用户*/
    void addUser(User user);

    /*更改用户信息*/
    void updateUser(User user);

    /*删除用户*/
    void deleteUser(User user);
}
