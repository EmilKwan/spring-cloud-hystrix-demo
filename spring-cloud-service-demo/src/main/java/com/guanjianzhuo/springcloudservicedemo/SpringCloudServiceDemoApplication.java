package com.guanjianzhuo.springcloudservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceDemoApplication.class, args);
	}
}
