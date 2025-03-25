package com.test.pro08.quiz03;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller()
@RequestMapping("/quiz03")
public class Quiz03Controller {
	@Autowired
	Quiz03DAO dao;
	
	@RequestMapping("/insertMember.do")
	public ModelAndView insertMember(
			@RequestParam Map<String, String> m,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		int result = dao.insertMember(m);
		ModelAndView mav = 
			new ModelAndView("redirect:/quiz03/listMembers.do");
		return mav;
	}
	
	@RequestMapping("/joinMember.do")
	public String joinMember(HttpServletRequest request,
			HttpServletResponse response) {
		return "/quiz03/joinMember";
	}
	
	@RequestMapping("/listMembers.do")
	public ModelAndView listMembers(HttpServletRequest request,
			HttpServletResponse response) {
		List<MemberDTO> membersList = dao.listMembers();
		ModelAndView mav = 
				new ModelAndView("/quiz03/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
}