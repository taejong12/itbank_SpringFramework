package com.test.pro07.ex05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VOController {
	@RequestMapping("/test/login4.do")
	public ModelAndView login(
			@ModelAttribute() MemberDTO member,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("test/result3");
		mav.addObject("info", member);
		
		return mav;
	}
	@RequestMapping("/test/loginForm4.do")
	public ModelAndView loginForm(HttpServletRequest request, 
			HttpServletResponse response) {
		return new ModelAndView("test/loginForm2");
	}
}


