package com.bing.rest.controller.redisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bing.rest.service.cache.JedisClient;

@Controller
@RequestMapping("/rest")
public class RedisController {
	@Autowired
	private JedisClient jedisClient;
	
	@RequestMapping("/redis")
	@ResponseBody
	public void getRedis(){
		jedisClient.set("sex", "nvnvnv");
	}
	
}
