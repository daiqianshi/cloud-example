package com.cloud.example.client.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientUserApplication.class, args);
	}

	@Value("${server.port}")
	private String port;

	@RequestMapping("/user")
	public String home(@RequestParam(value = "name", defaultValue = "Jerry") String name) {
		return "hello, user " + name + " welcome" + port;
	}

}
