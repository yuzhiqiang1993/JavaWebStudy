package com.xeon.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo1")
public class Demo1Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    @ResponseBody
    public String getPort() {
        System.out.println("port = " + port);
        return port;
    }
}
