package com.yzq.kotlin_springboot_maven.controller

import com.yzq.kotlin_springboot_maven.dao.data.User
import com.yzq.kotlin_springboot_maven.data.resp.BaseResp
import com.yzq.kotlin_springboot_maven.exception.BizException
import com.yzq.kotlin_springboot_maven.extend.tryCatchBlock
import com.yzq.kotlin_springboot_maven.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.TimeUnit


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService


    @GetMapping("/userList")
    fun queryAllUser(): BaseResp<List<User>> {
        val baseResp = BaseResp<List<User>>()

        tryCatchBlock(baseResp) {
            val list = userService.list()
            baseResp.data = list
        }

        return baseResp

    }


    @GetMapping("/requestError")
    fun requestError(): BaseResp<String> {
        val baseResp = BaseResp<String>()

        tryCatchBlock(baseResp) {
            throw BizException(-88, "后端异常了")
        }
        return baseResp

    }

    @GetMapping("/getUserCount")
    fun getUserCount(): BaseResp<Long> {
        val baseResp = BaseResp<Long>()
        tryCatchBlock(baseResp) {
            TimeUnit.SECONDS.sleep(2)
            val count = userService.count()
            baseResp.data = count
        }
        return baseResp
    }

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): BaseResp<String> {
        val baseResp = BaseResp<String>()
        tryCatchBlock(baseResp) {
            /*校验数据*/
            userService.save(user)
            baseResp.data = "添加成功"
        }
        return baseResp

    }


}