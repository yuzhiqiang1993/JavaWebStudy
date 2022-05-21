package com.xeon.redis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializer


@Configuration
class RedisConfig {

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        /*创建RedusTemplate对象*/
        val redisTemplate = RedisTemplate<String, Any>()
        /*设置链接工厂*/
        redisTemplate.setConnectionFactory(redisConnectionFactory)
        /*创建序列化工具*/
        val jackson2JsonRedisSerializer = GenericJackson2JsonRedisSerializer()
        /*设置key的序列化*/
        redisTemplate.keySerializer = RedisSerializer.string()
        redisTemplate.hashKeySerializer = RedisSerializer.string()
        /*设置值序列化*/
        redisTemplate.valueSerializer = jackson2JsonRedisSerializer
        redisTemplate.hashValueSerializer = jackson2JsonRedisSerializer
        return redisTemplate

    }
}