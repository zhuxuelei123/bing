package com.bing.bbs.controller.test;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bing.bbs.pojo.test.Test;
import com.bing.bbs.service.test.TestService;

@RequestMapping("/test")
@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		return testService.saveTest(new Test()) + "";
	}
	
	@RequestMapping("/redirection")
	@ResponseBody
	public void redirection(HttpServletResponse response) throws IOException {
		response.sendRedirect("http://localhost:8082/activiti/createModel/cs/1/csD");
	}

}
