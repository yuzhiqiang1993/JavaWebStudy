package com.xeon.demo.configuration;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 用来做服务之间的调用
 * @date : 2021/10/5
 * @time : 15:16
 */
@Configuration
public class RestConfiguration {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

