package com.test.pro10.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAspectJAutoProxy
public class TestController {

	@Autowired
	TestService service;
	
	@RequestMapping("/test02/logTest2.do")
	public String logTest2() {
		service.logTest2();
		return "/test01/result";
	}
}
