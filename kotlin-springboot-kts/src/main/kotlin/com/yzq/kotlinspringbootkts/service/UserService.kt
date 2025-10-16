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

    fun getById(id: Long): User? {
        return userMapper.selectById(id)
    }

    fun create(user: User): Int {
        return userMapper.insert(user)
    }

    fun updateById(user: User): Int {
        return userMapper.updateById(user)
    }

    fun deleteById(id: Long): Int {
        return userMapper.deleteById(id)
    }
}
