package com.cloud.example.server.feign.demo.controller;

import com.cloud.example.server.feign.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author app-hdshidaiqian
 * @Description
 * @Date 2019/5/16 21:38
 **/

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "hello")
    public String hello(@RequestParam(value = "name") String name) {
        return helloService.hello(name);
    }
}
