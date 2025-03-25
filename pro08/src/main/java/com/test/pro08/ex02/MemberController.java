package com.test.pro08.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("memberController2")
@RequestMapping("/test02")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/mem1.do")
	public ModelAndView selectId(HttpServletRequest request, 
			HttpServletResponse response) {
		String id = dao.selectId();
		ModelAndView mav = new ModelAndView("test02/selectId");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/mem2.do")
	public ModelAndView selectCount(HttpServletRequest request, 
			HttpServletResponse response) {
		int cnt = dao.selectCount();
		ModelAndView mav = new ModelAndView("test02/selectCount");
		mav.addObject("cnt", cnt);
		return mav;
	}
}