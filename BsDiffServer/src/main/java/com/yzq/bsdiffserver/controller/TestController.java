package com.yzq.bsdiffserver.controller;


import com.yzq.bsdiffserver.service.BsDiffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {


    @GetMapping("/testBsDiff")
    @ResponseBody
    public String testBsDiff() {

        BsDiffService.testBsDiff();

        return "test";
    }
}
