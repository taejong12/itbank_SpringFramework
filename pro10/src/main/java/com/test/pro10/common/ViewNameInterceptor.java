package com.test.pro10.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인터셉터(Interceptor)는 컨트롤러(@Controller)가 실행되기 전에 요청을 가로채서 사전/사후 처리하는 역할
// 즉, 사용자가 어떤 URL로 요청했는지 확인하고 그 정보를 request 속성에 저장하는 역할을 함
public class ViewNameInterceptor extends HandlerInterceptorAdapter {

	// preHandle() 메서드는 컨트롤러가 실행되기 전에 수행되는 로직
	// 반환값이 true 이면 요청이 정상적으로 계속 진행됨 (컨트롤러 진행)
	// 반환값이 false 이면 요청 처리가 중단됨 (컨트롤러 실행 X)
	// 현재 HandlerInterceptorAdapter 는 Spring 5부터 deprecated 되었지만
	// 기존 코드에서는 여전히 만이 사용됨
	// 요즘은 HandlerInterceptor 인터페이스를 직접 구현하는 방식으로 대체됨
	// Object handler -> 실행될 컨트롤러 정보 (일반적으로 @Controller 가 있는 클래스)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			String viewName = getViewName(request);
			request.setAttribute("viewName", viewName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private String getViewName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute
				("javax.servlet.include.request_uri");
		
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		
		if(!(contextPath == null)|| !("".equals(contextPath))) {
			begin = contextPath.length();
		}
		
		int end = 0;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		
		String viewName = uri.substring(begin, end);
		
		if(viewName.indexOf(".") != -1) {
			viewName = viewName.substring
					(0, viewName.lastIndexOf("."));
		}
		
		if(viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring
				(viewName.lastIndexOf("/", 1), viewName.length());
		}
		
		return viewName;
	}
}