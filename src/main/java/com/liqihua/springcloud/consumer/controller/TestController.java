package com.liqihua.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liqihua
 * @since 2018/6/24
 */
@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;


    //测试：访问服务springcloud-consul-provider的一个url
    @RequestMapping(value = "/aa")
    public String aa(){
        String result =  restTemplate.getForObject("http://springcloud-consul-provider/helloProviderController/hello", String.class);
        return result;
    }


    //获取服务springcloud-consul-provider的所有实例
    @RequestMapping(value = "/service")
    public Object service(){
        List<ServiceInstance> list =  discoveryClient.getInstances("springcloud-consul-provider");
        return list;
    }




}
