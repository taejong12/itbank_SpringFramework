package com.test.pro05.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// SimpleUrlController
// 1. Spring MVC에서 컨트롤러 역할을 하는 클래스(요청을 처리하는 역할)
// 2. Controller 인터페이스를 구현하는 클래스
// 3. handleRequest() 메서드를 오버라이딩해야 함
public class SimpleUrlController implements Controller{

	// handleRequest()
	// 1. 클라이언트의 요청을 받아서 어떤 화면(View)을 보여줄지 결정하는 역할
	// 2. HttpServletRequest -> 사용자의 요청 정보가 담김(예: 요청, URL, 파라미터 등)
	// 3. HttpServletResponse -> 응답 정보를 담음(예: 응답 헤더, 상태 코드 등) 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 *  ModelAndView
		 *  Model : 데이터
		 *  View : 화면
		 *  데이터 저장 및 출력, 그리고 화면에 대한 지정
		 */
		
		// ModelAndView 객체
		// 1. 뷰(View)와 데이터를 함께 저장하는 객체
		// 2. "test/index"는 뷰 이름 -> 실제 JSP 파일의 위치를 의미
		// 3. Spring에서 뷰 리졸버(View Resolver)가 JSP 파일을 찾는 규칙
		// 		"test/index" => "/WEB-INF/views/test/index.jsp"
		// 4. 사용자가 "http://localhost:8080/pro05/test/index" 에 접속하면
		//		->  "/WEB-INF/views/test/index.jsp" 가 실행되는 구조
		return new ModelAndView("test/index");
	}
}



