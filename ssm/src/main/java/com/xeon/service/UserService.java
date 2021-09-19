package com.xeon.service;


import com.xeon.dao.data.User;

import java.util.List;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: UserService
 * @date : 2021/9/19
 * @time : 11:54
 */
public interface UserService {

    List<User> listUser();

}
