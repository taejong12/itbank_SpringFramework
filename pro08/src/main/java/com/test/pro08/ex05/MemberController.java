package com.test.pro08.ex05;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller("memberController5")
@RequestMapping("/test05")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/insertMember.do")
	public ModelAndView insertMember(
			@ModelAttribute() MemberDTO m,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		int result = dao.insertMember(m);
		ModelAndView mav = 
			new ModelAndView("redirect:/test05/listMembers.do");
		return mav;
	}
	
	@RequestMapping("/joinMember.do")
	public String joinMember(HttpServletRequest request,
			HttpServletResponse response) {
		return "/test05/joinMember";
	}
	
	@RequestMapping("/listMembers.do")
	public ModelAndView listMembers(HttpServletRequest request,
			HttpServletResponse response) {
		List<MemberDTO> membersList = dao.listMembers();
		ModelAndView mav = 
				new ModelAndView("/test05/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
}