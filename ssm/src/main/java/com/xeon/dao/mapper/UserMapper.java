package com.xeon.dao.mapper;

import com.xeon.dao.data.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {

    public List<User> listUser();
}


