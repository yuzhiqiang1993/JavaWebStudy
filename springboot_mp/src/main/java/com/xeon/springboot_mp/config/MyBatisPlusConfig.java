package com.xeon.springboot_mp.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {

        System.out.println("MybatisPlusInterceptor 执行");
        final MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        /*分页*/
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));


        return mybatisPlusInterceptor;
    }


}
