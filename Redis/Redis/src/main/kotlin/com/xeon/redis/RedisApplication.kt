package com.xeon.redis

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.xeon.redis.data.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisApplication

fun main(args: Array<String>) {
    runApplication<RedisApplication>(*args)
}
