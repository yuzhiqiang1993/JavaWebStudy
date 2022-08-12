package com.yzq.kotlin_springboot_maven.dao.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.yzq.kotlin_springboot_maven.dao.data.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UserMapper : BaseMapper<User> {
    fun updateBatch(list: List<User>): Int
    fun batchInsert(@Param("list") list: List<User>): Int
    fun insertOrUpdate(record: User): Int
    fun insertOrUpdateSelective(record: User): Int
    fun queryCount(@Param("searchKey") searchKey: String): Long
    fun pageList(
        @Param("searchKey") searchKey: String,
        @Param("start") start: Long,
        @Param("pageSize") pageSize: Long,
    ): List<User>
}