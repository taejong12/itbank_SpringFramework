package com.test.pro10.ex08;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// Spring의 다국어(i18n) 기능을 활용하여 사용자의 언어(locale) 설정을 변경하는 역할
// 사용자가 언어 변경 요청을 하면 해당 언어를 세션에 저장하여 페이지 이동 시에도 유지할 수 있도록 함
// HandlerInterceptorAdapter -> Spring 5 이후에는 HandlerInterceptor 사용 권장
public class LocaleInterceptor extends HandlerInterceptorAdapter{

	// preHandle -> 컨트롤러 실행 전에 호출되는 인터셉터 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 사용자가 선택한 언어 가져옴
		String locale = request.getParameter("locale");
		
		if(locale == null) {
			locale="ko";
		}
		
		// Spring의 SessionLocaleResolver 를 사용하여 선택한 언어를 세션에 저장
		// 이후 사용자가 페이지를 이동해도 언어 설정이 유지됨
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
		
		// super.preHandle(...) 을 호출하면 컨트롤러 실행을 계속 진행함
		// 만약 false를 반환하면 컨트롤러 실행이 중단됨
		return super.preHandle(request, response, handler);
	}
}