package com.yzq.kotlin_springboot_maven.controller

import com.yzq.kotlin_springboot_maven.dao.data.TestBean
import com.yzq.kotlin_springboot_maven.dao.data.User
import com.yzq.kotlin_springboot_maven.data.base.BaseResp
import com.yzq.kotlin_springboot_maven.data.request.UserPageReq
import com.yzq.kotlin_springboot_maven.data.resp.PageResult
import com.yzq.kotlin_springboot_maven.exception.BizException
import com.yzq.kotlin_springboot_maven.extend.tryCatchBlock
import com.yzq.kotlin_springboot_maven.service.UserService
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.support.TransactionTemplate
import org.springframework.web.bind.annotation.*
import kotlin.system.measureTimeMillis


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var transactionTemplate: TransactionTemplate


    @GetMapping("/userList")
    fun queryAllUser(): BaseResp<List<User>> {
        val baseResp = BaseResp<List<User>>()

        tryCatchBlock(baseResp) {
            val list = userService.list()
            baseResp.data = list
        }

        return baseResp

    }

    @GetMapping("/test")
    fun test(): BaseResp<TestBean> {

        val baseResp = BaseResp<TestBean>()
        tryCatchBlock(baseResp) {
            baseResp.data = TestBean("yzq", 18, "1.0", "2.0")
        }
        return baseResp

    }


    @PostMapping("/modifyPassword")
    fun modifyPassword(@RequestParam new_pass: String) {

    }

    @PostMapping("/desc")
    fun desc(@RequestBody testBean: TestBean): String {

        println("testBean = ${testBean}")

        return "ok"

    }


    @GetMapping("/requestError")
    fun requestError(): BaseResp<String> {
        val baseResp = BaseResp<String>()

        tryCatchBlock(baseResp) {
            throw BizException(500, "后端异常了")
        }
        return baseResp

    }

    @GetMapping("/getUserCount")
    fun getUserCount(): BaseResp<Long> {
        val baseResp = BaseResp<Long>()
        tryCatchBlock(baseResp) {
            val count = userService.count()
            baseResp.data = count
        }
        return baseResp
    }

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): BaseResp<String> {
        val baseResp = BaseResp<String>()
        tryCatchBlock(baseResp) {

            /*事务*/
            transactionTemplate.execute {
                userService.save(user)

//                throw Exception("事务中出异常")
            }

            println("user = ${user.id}")
            userService.getById(user.id)
            baseResp.data = "添加成功"
        }
        return baseResp

    }

    @PostMapping("pageList")
    fun pageList(@RequestBody pageReq: UserPageReq): BaseResp<PageResult<List<User>>> {

        val baseResp = BaseResp<PageResult<List<User>>>()
        tryCatchBlock(baseResp) {
            baseResp.data = userService.pageList(pageReq)
        }

        return baseResp

    }

    @GetMapping("/testCoroutine")
    suspend fun testCoroutine(@RequestParam(defaultValue = "0") id: Long): BaseResp<Long> = coroutineScope {

        val baseResp = BaseResp<Long>()


        tryCatchBlock(baseResp) {
            val measureTimeMillis = measureTimeMillis {

                println("id = ${id}")

                val deferred1 = async {
                    println("Thread.currentThread().name = ${Thread.currentThread().name}")
                    delay(2000)
                    throw Exception("测试异常")
                    1
                }

                val deferred2 = async {
                    println("Thread.currentThread().name = ${Thread.currentThread().name}")
                    delay(2000)
                    2
                }

                val sum = awaitAll(deferred1, deferred2).sum() + id
                println("sum = ${sum}")

            }
            baseResp.data = measureTimeMillis
        }
        baseResp
    }
}
