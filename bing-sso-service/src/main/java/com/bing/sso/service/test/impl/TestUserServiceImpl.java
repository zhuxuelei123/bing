package com.bing.sso.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bing.sso.mapper.test.BbsUserMapper;
import com.bing.sso.pojo.test.BbsUser;
import com.bing.sso.service.test.TestUserService;
@Service
public class TestUserServiceImpl implements TestUserService {
	@Autowired
	private BbsUserMapper bbsUserMapper;
	@Override
	public void saveUser() {
//		BbsUser user = new BbsUser();
//		user.setRealName("主宰");
//		bbsUserMapper.insertSelective(user);
//		int i = 1/0;
		
		//testUser();
		BbsUser user = new BbsUser();
		user.setRealName("宙斯");
		BbsUser user2 = new BbsUser();
		user2.setRealName("米波");
		bbsUserMapper.insertSelective(user);
		int i = 1/0;
		bbsUserMapper.insertSelective(user2);
	}
	
	public void testUser(){
		BbsUser user = new BbsUser();
		user.setRealName("主宰");
		bbsUserMapper.insertSelective(user);
		int i = 1/0;
	}
}
