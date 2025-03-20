package com.test.pro06.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	
	// 회원 목록 조회
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 추가 (회원가입)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 가입 폼
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 상세 정보 조회
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 로그인 폼
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 로그인 처리
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 삭제
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 삭제 폼
	public ModelAndView delForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 정보 수정
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원 수정 폼
	public ModelAndView modifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception;



}
