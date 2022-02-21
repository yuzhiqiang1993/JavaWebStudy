package com.yzq.bsdiffserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BsDiffServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(BsDiffServerApplication.class, args);

        System.out.println("BsDiffServerApplication 启动了");


    }

}
