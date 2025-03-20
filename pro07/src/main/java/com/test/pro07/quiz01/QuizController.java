package com.test.pro07.quiz01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quiz01")
public class QuizController {
	@RequestMapping("/valueSelect.do")
	public ModelAndView valueSelect(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("/quiz01/valueSelect");
	}
	
	@RequestMapping("/result.do")
	public ModelAndView result(HttpServletRequest request,
			HttpServletResponse response) {
		String drink = request.getParameter("drink");
		
		ModelAndView mav = new ModelAndView("/quiz01/result");
		mav.addObject("drink", drink);
		return mav;
	}
}