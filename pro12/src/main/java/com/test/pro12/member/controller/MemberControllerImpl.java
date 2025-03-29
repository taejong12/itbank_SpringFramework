package com.test.pro12.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.pro12.member.dto.MemberDTO;
import com.test.pro12.member.service.MemberService;


@Controller
@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService service;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Override
	@RequestMapping("/member/listMembers.do")
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		String viewName = (String) request.getAttribute("viewName");
		
		Boolean login = (Boolean) session.getAttribute("isLogin"); 
		
		if (login != null && login == true) {
			List<MemberDTO> membersList = service.listMembers();
			mav.addObject("membersList", membersList);
			mav.setViewName(viewName);
		} else {
			mav.addObject("result", "notLogin");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@Override
	@RequestMapping("/member/memberDetail.do")
	public ModelAndView memberDetail(
			@ModelAttribute("dto") MemberDTO member,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		member = service.memberDetail(member.getId());
		mav.addObject("member", member);
		return mav;
	}

	@Override
	@RequestMapping("/member/delMember.do")
	public ModelAndView delMember(
			@RequestParam("id") String id,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int result = service.delMember(id);
		
		ModelAndView mav = new ModelAndView();
		if(result != 0) {
			mav.addObject("msg", "delMember");
			mav.addObject("id", id);
		} else {
			mav.addObject("msg", "delMember");
			mav.addObject("id", null);
		}
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping("/member/joinMember.do")
	public ModelAndView joinMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping("/member/addMember.do")
	public ModelAndView addMember(MemberDTO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		int result = service.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		mav.addObject("msg", "addMember");
		mav.addObject("id", member.getId());
		
		return mav;
	}
	
	@Override
	@RequestMapping("/member/modMember.do")
	public ModelAndView modMember(MemberDTO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		int result = service.modMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		mav.addObject("msg", "modMember");
		mav.addObject("id", member.getId());
		
		return mav;
	}

	@Override
	@RequestMapping("/member/loginForm.do")
	public ModelAndView loginForm(
			@RequestParam(value="action", required=false) String action,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public ModelAndView login(MemberDTO member, 
			RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		member = service.login(member);
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(member != null) {
			mav.setViewName("redirect:/member/listMembers.do");
			session.setAttribute("member", member);
			session.setAttribute("loginId", member.getId());
			session.setAttribute("isLogin", true);
			
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("redirect:"+action);
			} 
		} else {
			mav.setViewName("redirect:/member/loginForm.do");
			rAttr.addAttribute("result", "loginFailed");
		}
		
		return mav;
	}

	@Override
	@RequestMapping("/member/logout.do")
	public ModelAndView logout(
			RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		ModelAndView mav = new ModelAndView();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		
		if(session != null && isLogin != null) {
			session.invalidate();
			rAttr.addAttribute("result", "logout");
		} else {
			rAttr.addAttribute("result", "notLogin");
		}
		mav.setViewName("redirect:/member/loginForm.do");
		return mav;
	}
}



