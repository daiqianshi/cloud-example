package com.cloud.example.server.feign.demo.service;

import com.cloud.example.server.feign.demo.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName service
 * @Author app-hdshidaiqian
 * @Description
 * @Date 2019/5/16 21:24
 **/
@FeignClient(value = "client-user", fallback = HelloServiceImpl.class)
public interface HelloService {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name);
}
