package com.cloud.example.server.ribbon.demo.service.impl;

import com.cloud.example.server.ribbon.demo.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloServiceImpl
 * @Author app-hdshidaiqian
 * @Description
 * @Date 2019/5/16 21:26
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name) {
        return restTemplate.getForObject("http://CLIENT-USER/user?name="+name, String.class);
    }

    public String helloError(String name) {
        return "hello " + name + " 服务不可用";
    }
}
