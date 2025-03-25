package com.test.pro08.ex07;

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

@Controller("memberController7")
@RequestMapping("/test07")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/delMember.do")
	public ModelAndView delMember(
			@RequestParam("id") String id,
			HttpServletRequest request,
			HttpServletResponse response) {
		dao.deleteMember(id);
		
		ModelAndView mav = 
			new ModelAndView("redirect:/test05/listMembers.do");
		return mav;
	}
}