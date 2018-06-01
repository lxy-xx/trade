package com.safewind.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safewind.dao.TestDao;
import com.safewind.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;
	
	@Override
	public String getMessage() {
		
		return testDao.getMessage().getComTest();
	}

}
