package com.yzq.kotlinspringbootkts.service

import com.yzq.kotlinspringbootkts.mapper.UserMapper
import com.yzq.kotlinspringbootkts.data.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userMapper: UserMapper


    fun list(): List<User> {
        return userMapper.selectList(null)
    }

    fun deleteByPrimaryKey(id: Long): Int {
        return userMapper.deleteByPrimaryKey(id)
    }

    fun insert(record: User): Int {
        return userMapper.insert(record)
    }

    fun insertSelective(record: User): Int {
        return userMapper.insertSelective(record)
    }

    fun selectByPrimaryKey(id: Long): User {
        return userMapper.selectByPrimaryKey(id)
    }

    fun updateByPrimaryKeySelective(record: User): Int {
        return userMapper.updateByPrimaryKeySelective(record)
    }

    fun updateByPrimaryKey(record: User): Int {
        return userMapper.updateByPrimaryKey(record)
    }
}
