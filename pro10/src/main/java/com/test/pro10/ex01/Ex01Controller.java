package com.test.pro10.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex01Controller {

	// Ex01Controller.class 라는 이름의 로거(Logger) 객체를 생성
	// logger를 사용하여 로그를 남길 수 있음
	private static final Logger logger = LoggerFactory.getLogger(Ex01Controller.class);
	
	@RequestMapping("/test01/logTest1.do")
	public String logTest1(HttpServletRequest request, HttpServletResponse response) {
		logger.info("info 레벨: logTest1 메서드 = " + request.getMethod());
		logger.debug("debug 레벨: logTest1 메서드 = " + request.getMethod());
		return "/test01/result";
	}
}
