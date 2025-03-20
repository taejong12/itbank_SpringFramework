package com.test.pro07.ex07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro07.ex03.MemberDTO;

@Controller
public class AutoController {
	@Autowired
	AutoService service;
	
	@RequestMapping(value="/test/login6.do")
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test/result3");
		MemberDTO member = service.selectMember();
		mav.addObject("info", member);
		return mav;
	}
}
