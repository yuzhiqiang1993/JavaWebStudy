package com.example.demo.controller;

import com.example.demo.feign.MyDemo01Feign;
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


    @Autowired
    private MyDemo01Feign myDemo01Feign;

    /*比较原始的调用服务的方式*/
    @GetMapping("/getPort01")
    @ResponseBody
    public String getPort01() {


        /*先获取其他组件的ServiceInstance列表  可以通过 discoveryClient获取 */
        final List<ServiceInstance> discoveryClientInstances = this.discoveryClient.getInstances("MyDemo01");

        /*拿到具体的组件*/
        final ServiceInstance serviceInstance = discoveryClientInstances.get(0);
        /* 拿到URI  例如:http://192.168.50.60:8082 */
        final URI uri = serviceInstance.getUri();

        System.out.println("serviceInstance.getUri() = " + uri);

        String url = uri.toString() + "/demo1/port";
        System.out.println("url = " + url);

        /*调用方法*/
        final String forObject = this.restTemplate.getForObject(url, String.class);

        return "调用的远程服务端口号是:" + forObject;
    }


    /**
     * 通过Ribbon+RestTemplate的方式简化调用方式，同时实现负载均衡
     *
     * @return
     */
    @GetMapping("/getPort02")
    @ResponseBody
    public String getPort02() {
        /*简化的调用方式  注意 注入RestTemplate的地方要加LoadBalanced注解*/
        final String forObject = this.restTemplate.getForObject("http://MyDemo01/demo1/port", String.class);
        System.out.println("forObject = " + forObject);

        return "调用的远程服务端口号是:" + forObject;
    }

    /**
     * 使用feign代替Ribbon+RestTemplate的方式
     *
     * @return
     */
    @GetMapping("/getPort")
    @ResponseBody
    public String getPort() {

        final String port = myDemo01Feign.getPort();

        return "调用的远程服务端口号是:" + port;
    }


}
