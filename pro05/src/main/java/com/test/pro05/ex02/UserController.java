package com.test.pro05.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


// MultiActionController
// 1. 하나의 클래스에서 여러 개의 액션(메서드)을 처리하는 컨트롤러
// 2. 메서드 단위로 요청 URL을 매핑할 수 있음
// 3. @RequestMapping이 나오기 전까지 많이 쓰이던 방식

// UserController
// 1. MultiActionController를 상속받아 URL 별로 메서드 분리 가능
// 2. PropertiesMethodNameResolver로 어떤 메서드 실행할지 결정됨
public class UserController extends MultiActionController{
	
	// "/test/login.do" 호출 시 실행
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// ModelAndView.addObject("키", "값"); : mav 에 값 저장
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		
		// ModelAndView.setViewName("jsp 페이지 이름")
		mav.setViewName("test/result");
		return mav;
	}
	
	// "/test/loginForm.do" 요청 시 실행
	public ModelAndView loginForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// "loginForm.jsp" 로 이동
		return new ModelAndView("test/loginForm");
	}
	
	// "/test/memberForm.do" 요청 시 실행
	public ModelAndView memberForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// "memberForm.jsp" 로 이동
		return new ModelAndView("/test"+getViewName(request));
	}
	
	// "/test/memberInfo.do" 요청 시 실행
	public ModelAndView memberInfo(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("/test"+getViewName(request));
		
		mav.addObject("id", request.getParameter("id"));
		mav.addObject("pwd", request.getParameter("pwd"));
		mav.addObject("name", request.getParameter("name"));
		mav.addObject("email", request.getParameter("email"));
		
		// "memberInfo.jsp" 로 이동
		return mav;
	}
	
	// 현재 요청된 URL로부터 "뷰 이름"만 추출하는 기능(메서드)
	public String getViewName(HttpServletRequest request) {
		
		// contextPath
		// 1. 프로젝트 루트 경로
		// 2. 예: /pro05
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
		// include 요청
		// 1. 현재 페이지 안에 다른 페이지(JSP나 서블릿)를 끼워 넣는 것
		
		// "javax.servlet.include.request_uri"
		// 1. include 방식으로 요청이 들어오면 원래 요청한 URI는 그대로 남아있음
		// 2. 지금 처리 중인 include 대상의 URI는 "javax.servlet.include.request_uri" 라는 속성으로 저장됨
		// 3. 현재 실행 중인 서블릿이나 JSP의 URI를 가져오고 싶으면 
		//		request.getAttribute("javax.servlet.include.request_uri")로 꺼내야 함
		// 4. request.getAttribute("javax.servlet.include.request_uri") => "test/memberForm.do"
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		System.out.println("uri : " + uri);
		
		// request.getRequestURI()
		// 1. 클라이언트가 처음 보낸 URL의 URL 부분 전체를 가져옴
		// 2. request.getRequestURI() => /pro05/test/memberForm.do
		// 3. request.getQueryString() => id=abc
		
		// 조건문
		// 1. include 요청이라면 "javax.servlet.include.request_uri" 값이 존재
		// 2. 일반 요청이면 include 속성이 없어서 null
		// 3. include 요청이 없으면 "request.getRequestURI()" 로 원래 요청된 URI 전체를 가져옴
		// 4. 일반요청 => request.getRequestURI() / include 요청 => request.getAttribute("javax.servlet.include.request_uri")
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		// begin : 문자열을 자를 시작 위치값
		int begin = 0;
		if(!(contextPath == null) || "".equals(contextPath)) {
			begin = contextPath.length();
			System.out.println("contextPath.length(): "+begin);
		}
		
		// end : 문자열의 끝 위치값 저장
		int end = 0;
		
		// ";", "?" 가 있으면 그 전까지만 잘라내기 위한 로직
		// URL 뒤에 파라미터가 붙는 경우
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		System.out.println("uri.indexOf() : "+end);
		
		// URL에서 원하는 경로 부분만 추출 => 예: "/test/memberForm.do" 
		String path = uri.substring(begin, end);
		System.out.println("첫번째 경로 : " + path);
		
		// .do 제거 => 예: /test/memberForm
		if (path.lastIndexOf(".") != -1) {
			path = path.substring(0, path.lastIndexOf("."));
		}
		System.out.println("두번째 경로 : " + path);
		
		// 마지막 / 기준으로 잘라서 최종 뷰 이름 추출 => 예: /memberForm
		if (path.lastIndexOf("/") != -1) {
			path = path.substring(path.lastIndexOf("/"), path.length());
		}
		System.out.println("세번째 경로 : " + path);
		
		return path;
	}
}




