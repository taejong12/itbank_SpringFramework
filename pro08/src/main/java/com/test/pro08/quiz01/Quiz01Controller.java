package com.test.pro08.quiz01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

/*
아이디를 이용하여 하나의 MemberDTO 객체를 가져와서 출력
select * from member where id='hong'
*/
@Controller
public class Quiz01Controller {
	@Autowired
	Quiz01DAO dao;
	
	@RequestMapping("/quiz01/result.do")
	public ModelAndView quiz01(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("quiz01/result");
		
		MemberDTO member = dao.selectMember();
		mav.addObject("member", member);
		return mav;
	}

}









