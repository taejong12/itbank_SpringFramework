package com.test.pro08.ex08;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller("memberController8")
@RequestMapping("/test08")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/searchMemberForm.do")
	public String searchMember(HttpServletRequest request,
			HttpServletResponse response) {
		return "/test08/searchMemberForm";
	}
	
	@RequestMapping("/searchMember.do")
	public ModelAndView searchMember(
			@ModelAttribute MemberDTO m,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<MemberDTO> membersList =
				dao.searchMember(m);
		ModelAndView mav = 
			new ModelAndView("/test08/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	@RequestMapping("/searchMemberForm2.do")
	public String searchMember2(HttpServletRequest request,
			HttpServletResponse response) {
		return "/test08/searchMemberForm2";
	}
	
	@RequestMapping("/searchMember2.do")
	public ModelAndView searchMember2(
			@ModelAttribute MemberDTO m,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<MemberDTO> membersList =
				dao.searchMember2(m);
		ModelAndView mav = 
			new ModelAndView("/test08/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	@RequestMapping("/foreachSelect.do")
	public ModelAndView foreachSelect(
			HttpServletRequest request,
			HttpServletResponse response) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("이순신");
		nameList.add("유관순");
		nameList.add("123");
		
		
		List<MemberDTO> membersList =
				dao.foreachSelect(nameList);
		ModelAndView mav = 
			new ModelAndView("/test08/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
}