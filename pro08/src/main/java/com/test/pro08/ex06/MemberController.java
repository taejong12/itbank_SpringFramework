package com.test.pro08.ex06;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller("memberController6")
@RequestMapping("/test06")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/modMember.do")
	public String modMember(HttpServletRequest request,
			HttpServletResponse response) {
		return "/test06/modMember";
	}
	
	@RequestMapping("/updateMember.do")
	public ModelAndView updateMember(
			@ModelAttribute() MemberDTO m,
			HttpServletRequest request,
			HttpServletResponse response) {
		dao.updateMember(m);
		ModelAndView mav = 
			new ModelAndView("redirect:/test05/listMembers.do");
		return mav;
	}
}