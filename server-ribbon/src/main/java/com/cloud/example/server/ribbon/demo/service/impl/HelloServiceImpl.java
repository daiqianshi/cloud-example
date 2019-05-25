package com.cloud.example.server.ribbon.demo.service.impl;

import com.cloud.example.server.ribbon.demo.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.LoadBalancerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryContext;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient balancerClient;

    @Override
    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name) {

        /*
         * 1. 无服务注册
         * String result =  restTemplate.getForObject("http://localhost:8762/user?name="+name, String.class);
         * 2. 有服务注册，单例
         * String result =  restTemplate.getForObject("http://CLIENT-USER/user?name="+name, String.class);
         */
        /*
         * 3. 有服务注册，多例
         *  3.1 未引入Ribbon
         *  List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLIENT-USER");
         *  Random rand = newRandom();
         *  ServiceInstance instance = serviceInstances.get(rand.nextInt(serviceInstances.size()))
         *  String result =  restTemplate.getForObject("http://"+instance.getHost() +":"+instance.getPort()
                +"/user?name="+name, String.class);
         *  3.2 需要在注入restTemplate bean 时的添加@LoadBalanced注解，就是它帮助我们实现负载均衡
         *  String result =  restTemplate.getForObject("http://CLIENT-USER/user?name="+name, String.class);
         *  3.3 注入 LoadBalancerClient bean
         *  String result =  restTemplate.getForObject("http://"+instance.getHost() +":"+instance.getPort()
         *      +"/user?name="+name, String.class);
         */
        String result =  restTemplate.getForObject("http://CLIENT-USER/user?name="+name, String.class);
        return result;
    }

    public String helloError(String name) {
        return "hello " + name + " 服务不可用";
    }
}
