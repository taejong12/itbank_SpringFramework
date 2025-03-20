package com.test.pro06.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.test.pro06.member.service.MemberService;
import com.test.pro06.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController{
	
	public MemberService memberService;
	// memberService setter 주입
	public void setMemberService (MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 회원 목록 조회
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberVO> memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView("listMembers");
		mav.addObject("memberList", memberList);
		// "listMembers.jsp" 로 데이터 전달하여 이동
		return mav;
	}

	// 회원 추가 (회원가입)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		int result = memberService.addMember(id, pwd, name, email);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.write("<script>");
			out.write("alert('회원가입에 성공했습니다');");
			out.write("location.href='/pro06/member/loginForm.do';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('회원가입에 실패했습니다');");
			out.write("location.href='/pro06/member/memberForm.do';");
			out.write("</script>");
		}
		return null;
	}

	// 회원 가입 폼
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav =new ModelAndView("memberForm");
		return mav;
	}

	// 회원 상세 정보 조회
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav =new ModelAndView("memberDetail");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		MemberVO member = memberService.memberDetail(id);
		mav.addObject("member",member);
		return mav;
	}
	
	// 로그인 폼
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav =new ModelAndView("loginForm");
		return mav;
	}
	
	// 로그인 처리
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		int result = memberService.login(id, pwd);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.write("<script>");
			out.write("alert('로그인에 성공했습니다');");
			out.write("location.href='/pro06/member/listMembers.do';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('로그인에 실패했습니다');");
			out.write("location.href='/pro06/member/loginForm.do';");
			out.write("</script>");
		}
		return null;
	}
	
	// 회원 삭제
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		ModelAndView mvc = new ModelAndView("del");
		
		int result = memberService.del(id, pwd);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.write("<script>");
			out.write("alert('"+id+"님의 정보가 삭제되었습니다');");
			out.write("location.href='/pro06/member/listMembers.do';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('삭제에 실패했습니다');");
			out.write("location.href='/pro06/member/listMembers.do';");
			out.write("</script>");
		}
		return null;
	}
	
	// 회원 삭제 폼
	public ModelAndView delForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mvc = new ModelAndView("delForm");
		return mvc;
	}
	
	// 회원 정보 수정
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ModelAndView mvc = new ModelAndView("modify");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		int result = memberService.modify(id,pwd,name,email);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.write("<script>");
			out.write("alert('수정에 성공했습니다');");
			out.write("location.href='/pro06/member/listMembers.do';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('수정에 실패했습니다');");
			out.write("location.href='/pro06/member/listMembers.do';");
			out.write("</script>");
		}
		
		return null;
	}
	
	// 회원 수정 폼
	public ModelAndView modifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mvc = new ModelAndView("modifyForm");
		return mvc;
	}
}
