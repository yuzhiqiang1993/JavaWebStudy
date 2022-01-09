package com.yzq.kotlin_springboot_maven.controller

import com.yzq.kotlin_springboot_maven.constants.RespEnum
import com.yzq.kotlin_springboot_maven.dao.data.User
import com.yzq.kotlin_springboot_maven.data.resp.BaseResp
import com.yzq.kotlin_springboot_maven.exception.ApiException
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
        try {
            val list = userService.list()
            baseResp.data = list
        } catch (e: Exception) {
            e.printStackTrace()
            baseResp.error(RespEnum.ERROR)
        }
        return baseResp

    }


    @GetMapping("/requestError")
    fun requestError(): BaseResp<String> {
        val baseResp = BaseResp<String>()
        try {
//            TimeUnit.SECONDS.sleep(1)
            throw ApiException(-88, "后端异常了")
        } catch (e: Exception) {
            baseResp.error(RespEnum.ERROR)
        }
        return baseResp

    }

    @GetMapping("/getUserCount")
    fun getUserCount(): BaseResp<Long> {
        val baseResp = BaseResp<Long>()
        try {
            TimeUnit.SECONDS.sleep(2)
            val count = userService.count()
            baseResp.data = count
        } catch (e: Exception) {
            e.printStackTrace()
            baseResp.error(RespEnum.ERROR)
        }
        return baseResp
    }

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): BaseResp<String> {
        val baseResp = BaseResp<String>()

        try {
            /*校验数据*/
            if (user.check()) {
                userService.save(user)
                baseResp.data = "添加成功"
            } else {
                baseResp.error(RespEnum.PARAMETER_ERROR)
            }
        } catch (e: Exception) {

            baseResp.error(RespEnum.ERROR)
        }

        return baseResp

    }


}