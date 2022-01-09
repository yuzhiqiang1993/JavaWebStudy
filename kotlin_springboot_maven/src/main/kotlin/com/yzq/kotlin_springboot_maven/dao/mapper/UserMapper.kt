package com.yzq.kotlin_springboot_maven.dao.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.yzq.kotlin_springboot_maven.dao.data.User
import org.springframework.stereotype.Repository

@Repository
interface UserMapper : BaseMapper<User> {

}