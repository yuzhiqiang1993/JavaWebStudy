package com.xeon.dao.impl;

import com.xeon.dao.UserDao;
import com.xeon.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;




/**
 * @description: 数据持久层
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/9/4
 * @time   : 14:36
 */
@Repository
public class UserDaoImpl implements UserDao {


    /*正常来讲dao层负责链接数据库操作数据，这里我们模拟一下*/

    private static Map<Integer, User> userMap = new HashMap<>();

    static {

        userMap.put(1, new User(1, "喻志强", 27));
        userMap.put(2, new User(2, "zhangsan", 27));
        userMap.put(3, new User(3, "lisi", 27));


    }


    @Override
    public User getUserById(Integer id) {
        return userMap.get(id);
    }
}
