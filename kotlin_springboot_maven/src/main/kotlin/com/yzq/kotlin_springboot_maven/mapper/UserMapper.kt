package com.yzq.kotlin_springboot_maven.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.yzq.kotlin_springboot_maven.dao.data.User
import org.apache.ibatis.annotations.Param

interface UserMapper : BaseMapper<User?> {
    fun updateBatch(list: List<User>): Int
    fun batchInsert(@Param("list") list: List<User>): Int
    fun insertOrUpdate(record: User): Int
    fun insertOrUpdateSelective(record: User): Int
}