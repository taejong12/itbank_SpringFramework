package com.test.pro10.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	TestDAO dao;
	
	public void logTest2() {
		dao.logTest2();
	}
}
