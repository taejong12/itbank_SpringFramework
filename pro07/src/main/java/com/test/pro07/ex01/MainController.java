package com.test.pro07.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// MainController mainController = new MainController();
// @Controller
// MainController main = new MainController();
@Controller("main")

// 클래스에서 RequestMapping 이 클래스에 시작되는 uri 이름
// /test 시작하는 경로는 이 Controller가 담당함
@RequestMapping("/test")
public class MainController {
	
	// 메서드 기준의 RequestMapping 은 /test/ 뒤에 오는 경로
	// /test/main1.do 이면 main1 메서드 실행
	@RequestMapping("/main1.do")
	public ModelAndView main1(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/test/main");
		mav.addObject("msg", "main1");
		return mav;
	}

	// /test/main2.do 이면 main2 메서드 실행	
	@RequestMapping("/main2.do")
	public ModelAndView main2(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/test/main");
		mav.addObject("msg", "main2");
		return mav;
	}
}





