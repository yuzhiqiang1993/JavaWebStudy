package com.yzq.kotlin_springboot_maven.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * @description: Mybatis plus的一些配置
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */
@Configuration
class MyBatisPlusConfig {

    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        val mybatisPlusInterceptor = MybatisPlusInterceptor()
        /*分页*/
        mybatisPlusInterceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
        return mybatisPlusInterceptor
    }

}