package com.xeon.redis

import MoshiUtil
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.xeon.redis.data.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private lateinit var redisTemplate: RedisTemplate<String, Any>


    @Test
    fun testRedisString() {
        val user = User("xeon", 20)
        redisTemplate.opsForValue().set("user", MoshiUtil.toJson(user))
        val getUserJsonStr = redisTemplate.opsForValue().get("user") as String
        println("getUserJsonStr = ${getUserJsonStr}")
        val fromJson = MoshiUtil.fromJson<User>(getUserJsonStr)

        println("fromJson = ${fromJson}")
    }

}
