package com.test.pro07.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView addMember(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView memberForm(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView memberDetail(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView loginForm(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView memberDel(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	public ModelAndView memberMod(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
}