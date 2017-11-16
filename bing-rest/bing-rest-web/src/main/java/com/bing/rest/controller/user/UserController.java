package com.bing.rest.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(value = "swagger测试", description ="工单流程配置数据接口")
@Controller
@RequestMapping("/rest")
public class UserController {
	
	@ApiOperation(value = "获取list集合",notes="参数为字符串")
	@RequestMapping("/swagger/test")
	@ResponseBody
	public List<String> getUser(@ApiParam(value = "传字符传")String sss){
		List<String> s = new ArrayList<String>();
		return s;
	}
}
