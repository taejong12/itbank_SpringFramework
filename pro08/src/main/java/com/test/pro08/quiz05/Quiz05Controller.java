package com.test.pro08.quiz05;

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

@Controller
@RequestMapping("/quiz05")
public class Quiz05Controller {
	@Autowired
	Quiz05DAO dao;
	
	@RequestMapping("/search.do")
	public String search(HttpServletRequest request,
			HttpServletResponse response) {
		return "/quiz05/search";
	}
	
	@RequestMapping("/result.do")
	public ModelAndView result(
			@ModelAttribute() MemberDTO m,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		List<MemberDTO> membersList =
				dao.selectEmail(m);
		
		ModelAndView mav = new ModelAndView("/quiz05/listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}
}













