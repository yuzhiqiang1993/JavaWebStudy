package com.yzq.kotlinspringbootkts.controller

import com.yzq.kotlinspringbootkts.model.User
import com.yzq.kotlinspringbootkts.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {


    @Autowired
    private lateinit var userService: UserService


    @GetMapping("/list")
    fun list(): List<User> {
        return userService.list()
    }


}
