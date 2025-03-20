package com.test.pro07.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	// value={"url1", "url2"}
	@RequestMapping(value={"/test/loginForm.do", "/test/loginForm2.do"})
	public ModelAndView loginForm(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("test/loginForm");
		return mav;
	}
	
	@RequestMapping("/test/login.do")
	public ModelAndView login(HttpServletRequest request,
		HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/test/result");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		mav.addObject("id", id);
		mav.addObject("name", name);
		
		return mav;
	}
	
}








