package com.yzq.kotlinspringbootkts.controller

import com.yzq.kotlinspringbootkts.data.User
import com.yzq.kotlinspringbootkts.service.UserService
import com.yzq.kotlinspringbootkts.dto.CreateUserRequest
import com.yzq.kotlinspringbootkts.dto.UpdateUserRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {


    @Autowired
    private lateinit var userService: UserService


    @GetMapping("/list")
    fun list(): List<User> {
        return userService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): User? {
        return userService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody req: CreateUserRequest): Int {
        val user = User(
            id = 0L,
            name = req.name,
            age = req.age,
            gender = req.gender,
            createTime = null,
            updateTime = null,
            enable = req.enable
        )
        return userService.create(user)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody req: UpdateUserRequest
    ): Int {
        val user = User(
            id = id,
            name = req.name,
            age = req.age,
            gender = req.gender,
            createTime = null,
            updateTime = null,
            enable = req.enable
        )
        return userService.updateById(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): Int {
        return userService.deleteById(id)
    }


}
