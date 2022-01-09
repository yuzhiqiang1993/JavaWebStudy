package com.yzq.kotlin_springboot_maven.service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.yzq.kotlin_springboot_maven.dao.data.User
import com.yzq.kotlin_springboot_maven.dao.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImp : ServiceImpl<UserMapper, User>(), UserService {


}