package com.xeon.redis

import com.xeon.redis.data.User
import com.xeon.redis.util.JacksonUtil
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
        val user = User("xeon", 22)
        redisTemplate.opsForValue().set("user", JacksonUtil.toJson(user))
        val getUserJsonStr = redisTemplate.opsForValue().get("user") as String
        println("getUserJsonStr = ${getUserJsonStr}")
        val fromJson = JacksonUtil.fromJson<User>(getUserJsonStr)

        println("fromJson = ${fromJson}")

        println("fromJson.name = ${fromJson.name}")
    }

}
