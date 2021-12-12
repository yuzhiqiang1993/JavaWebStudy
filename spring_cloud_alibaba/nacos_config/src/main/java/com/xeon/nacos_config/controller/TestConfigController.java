package com.xeon.nacos_config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 测试远程配置
 * @date : 2021/10/5
 * @time : 18:25
 */

@RestController
@RefreshScope
public class TestConfigController {

    @Value("${remote.config}")
    private String remoteConfigVal;


    @GetMapping("/config")
    public String getRemoteConfigVal() {

        return this.remoteConfigVal;
    }


}

