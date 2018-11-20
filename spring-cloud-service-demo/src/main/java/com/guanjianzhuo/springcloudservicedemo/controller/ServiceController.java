package com.guanjianzhuo.springcloudservicedemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServiceController {
	@RequestMapping("/service")
	public Map<String, Object> service() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "This is a service demo.");
		return result;
	}
}
