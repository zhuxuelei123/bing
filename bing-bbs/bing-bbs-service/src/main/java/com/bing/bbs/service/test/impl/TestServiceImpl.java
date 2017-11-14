package com.bing.bbs.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bing.bbs.mapper.test.TestMapper;
import com.bing.bbs.pojo.test.Test;
import com.bing.bbs.pojo.test.TestExample;
import com.bing.bbs.service.test.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public int saveTest(Test test) {
		test.setId(2);
		test.setName("测试数据");
		update();
		int rows = testMapper.insert(test);
		return rows;
	}
	
	private void update() {
		TestExample example = new TestExample();
		example.createCriteria().andIdEqualTo(1);
		Test test = new Test();
		test.setName("测试YY");
		int i = 1/0;
		testMapper.updateByExampleSelective(test, example);
	}

}
