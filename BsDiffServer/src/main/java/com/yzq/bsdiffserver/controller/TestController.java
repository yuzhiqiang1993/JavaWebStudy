package com.yzq.bsdiffserver.controller;


import com.yzq.bsdiffserver.service.BsDiffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        String hostAddress = "";
        try {

            System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
            final InetAddress localHost = InetAddress.getLocalHost();
            hostAddress = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "可以正常访问 hostAddress:" + hostAddress;
    }


    @GetMapping("/testBsDiff")
    @ResponseBody
    public String testBsDiff() {

        System.out.println("请求了接口");
        BsDiffService.testBsDiff();

        return "test";
    }
}
