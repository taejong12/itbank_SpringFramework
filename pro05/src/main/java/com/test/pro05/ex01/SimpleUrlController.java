package com.test.pro05.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller{

	/*
	 *  ModelAndView
	 *  Model : 데이터
	 *  View : 화면
	 *  데이터 저장 및 출력, 그리고 화면에 대한 지정
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// test/index => /WEB-INF/views/test/index.jsp
		return new ModelAndView("test/index");
	}

}



