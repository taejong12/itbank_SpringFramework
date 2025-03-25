package com.test.pro08.quiz04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller
@RequestMapping("/quiz04")
public class Quiz04Controller {
	@Autowired
	Quiz04DAO dao;
	
	@RequestMapping("/search.do")
	public String search(HttpServletRequest request,
			HttpServletResponse response) {
		return "/quiz04/search";
	}
	
	@RequestMapping("/result.do")
	public ModelAndView result(
			@ModelAttribute() MemberDTO m,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		MemberDTO member = null;
		
		if(m.getPwd().equals("")) {
			member = dao.selectMemberById(m.getId());
		} else {
			member = dao.selectMemberIdPwd(m);
		}
		
		ModelAndView mav = new ModelAndView("/quiz04/result");
		mav.addObject("member", member);
		return mav;
	}
}













