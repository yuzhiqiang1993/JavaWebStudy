package com.yzq.kotlinspringbootkts.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.yzq.kotlinspringbootkts.model.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User> {
    fun deleteByPrimaryKey(id: Long): Int
    fun insertSelective(record: User): Int
    fun selectByPrimaryKey(id: Long): User
    fun updateByPrimaryKeySelective(record: User): Int
    fun updateByPrimaryKey(record: User): Int
}
