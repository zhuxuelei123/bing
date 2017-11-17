package com.bing.sso.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bing.sso.service.test.TestUserFindService;
import com.bing.sso.service.test.TestUserService;

@Service
public class TestUserFindServiceImpl implements TestUserFindService{
	@Autowired
	private TestUserService testUserService;
	@Override
	public void findUserById() {
		testUserService.saveUser();
	}
	
}
