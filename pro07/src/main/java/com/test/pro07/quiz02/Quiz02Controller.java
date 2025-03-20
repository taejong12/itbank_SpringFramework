package com.test.pro07.quiz02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Quiz02Controller {
	@RequestMapping("/quiz02/memberJoin.do")
	public ModelAndView memberJoin(HttpServletRequest request, 
			HttpServletResponse response) {
		return new ModelAndView("/quiz02/memberJoin");
	}
	
	@RequestMapping("/quiz02/result.do")
	public ModelAndView result(
			@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/quiz02/result");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		return mav;
	}
}



