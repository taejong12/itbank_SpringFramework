package com.test.pro08.ex04;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro08.ex01.MemberDTO;

@Controller("memberController4")
@RequestMapping("/test04")
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("/mem1.do")
	public ModelAndView selectId(
			@RequestParam("action") String action,
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String viewName = "";
		ModelAndView mav = new ModelAndView();
		if(action == null || action.equals("listMembers")) {
			List<MemberDTO> membersList = 
					dao.selectAllMemberList();
			mav.addObject("membersList", membersList);
			viewName = "test04/listMembers";
		} else if (action.equals("selectMemberById")) {
			String id = request.getParameter("value");
			MemberDTO member = dao.selectMemberById(id);
			mav.addObject("member", member);
			viewName = "test04/memberInfo";
		} else if (action.equals("selectMemberByPwd")) {
			String pwd = request.getParameter("value");
			List<MemberDTO> membersList = 
					dao.selectMemberByPwd(pwd);
			mav.addObject("membersList", membersList);
			viewName = "test04/listMembers";
		}
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping("/search.do")
	public String search(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/test04/search";
	}
}






