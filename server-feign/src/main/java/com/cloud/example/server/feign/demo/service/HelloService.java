package com.cloud.example.server.feign.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName service
 * @Author app-hdshidaiqian
 * @Description
 * @Date 2019/5/16 21:24
 **/
@FeignClient(value = "client-user")
public interface HelloService {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String hello(String name);
}
