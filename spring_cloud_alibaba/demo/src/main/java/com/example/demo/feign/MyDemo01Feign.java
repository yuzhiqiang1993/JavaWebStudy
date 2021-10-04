package com.example.demo.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 使用feign取代 Ribbon + RestTemplate 的方式来实现基于接口调用的负载均衡，
 * 比 Ribbon 使用起来要更加简便，只需要创建接口并添加相关注解配置，即可实现服务消费的负载均衡。
 * FeignClient()中设置服务名称
 * @date : 2021/10/4
 * @time : 17:37
 */
@FeignClient("MyDemo01")
public interface MyDemo01Feign {

    /*这里映射服务接口*/
    @GetMapping("/demo1/port")
    public String getPort();
}
