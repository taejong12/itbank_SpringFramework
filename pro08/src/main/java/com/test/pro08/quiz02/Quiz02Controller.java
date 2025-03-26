package com.test.pro08.quiz02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Quiz02Controller {
	@Autowired
	Quiz02DAO dao;
	
	@RequestMapping("/quiz02/form.do")
	public ModelAndView  form(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("/quiz02/search");
	}
	
	@RequestMapping("/quiz02/result.do")
	public ModelAndView result(
			@RequestParam("id") String id,
			@RequestParam(value="pwd", required=false) String pwd,
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/quiz02/result");
		
		if(pwd.equals("")) {
			String name = dao.selectName(id);
			mav.addObject("name", name);
		} else {
			int result = dao.loginCheck(id, pwd);
			mav.addObject("result", result);
		}

		return mav;
	}
}