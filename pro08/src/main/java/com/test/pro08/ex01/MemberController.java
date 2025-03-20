package com.test.pro08.ex01;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test01")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/mem1.do")
	public ModelAndView listMembers(HttpServletRequest request, 
			HttpServletResponse response) {
		List<MemberDTO> membersList = dao.selectAllList();
		ModelAndView mav = new ModelAndView("test01/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
}








