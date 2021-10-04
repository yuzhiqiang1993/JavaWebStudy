package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;


    /*这个要手动注入*/
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getPort")
    @ResponseBody
    public String getPort() {


        /*先获取其他组件的ServiceInstance列表  可以通过 discoveryClient获取 */
        final List<ServiceInstance> discoveryClientInstances = this.discoveryClient.getInstances("demo1");

        /*拿到具体的组件*/
        final ServiceInstance serviceInstance = discoveryClientInstances.get(0);
        /* 拿到URI  例如:http://192.168.50.60:8082 */
        final URI uri = serviceInstance.getUri();

        System.out.println("serviceInstance.getUri() = " + uri);

        String url = uri.toString() + "/demo1/port";
        System.out.println("url = " + url);

        /*调用方法*/
        final String forObject = this.restTemplate.getForObject(url, String.class);

        System.out.println("forObject = " + forObject);

        return "调用的远程服务端口号是:"+forObject;
    }

}
