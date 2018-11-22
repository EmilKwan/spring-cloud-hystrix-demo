package com.guanjianzhuo.springcloudclientdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/client")
	// 熔断触发命令，超时或者抛异常都会触发
	@HystrixCommand(fallbackMethod = "hystrixWork")
	public Map<String, Object> client() {
		ResponseEntity<String> resp = restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE-DEMO/service", String.class);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "Call service.");
		result.put("resp", resp.getBody());
		return result;
	}

	public Map<String, Object> hystrixWork(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "error.");
		return result;
	}
}
