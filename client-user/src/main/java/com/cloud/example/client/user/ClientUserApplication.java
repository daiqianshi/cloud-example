package com.cloud.example.client.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@RestController
public class ClientUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientUserApplication.class, args);
	}

	@Value("${server.port}")
	private String port;

	@Value("${user.name}")
	private String userName;

	@RequestMapping("/user")
	public String user(@RequestParam(value = "name") String name) {
		if (StringUtils.isEmpty(name)) {
			name = userName;
		}
		return "hello, user " + name + " welcome " + port;
	}

}
