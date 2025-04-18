package com.test.pro08.ex03;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller("memberController3")
@RequestMapping("/test03")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/mem1.do")
	public ModelAndView selectAllMemberMap(
			HttpServletRequest request,
			HttpServletResponse response) {
		List<MemberDTO> membersList = 
				dao.selectAllMemberMap();
		ModelAndView mav = 
				new ModelAndView("test03/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
}