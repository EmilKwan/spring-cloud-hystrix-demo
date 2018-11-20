package com.guanjianzhuo.springcloudclientdemo.controller;

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
	public Map<String, Object> client() {
		ResponseEntity<String> resp = restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE-DEMO/service", String.class);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "Call service.");
		result.put("resp", resp.getBody());
		return result;
	}
}
