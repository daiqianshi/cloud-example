package com.cloud.example.server.feign.demo.service.impl;

import com.cloud.example.server.feign.demo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Author app-hdshidaiqian
 * @Description
 * @Date 2019/5/17 11:05
 **/
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "hello " + name + " 服务不可用";
    }
}
