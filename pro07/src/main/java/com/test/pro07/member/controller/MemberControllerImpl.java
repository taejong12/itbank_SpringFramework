package com.test.pro07.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.test.pro07.member.service.MemberService;
import com.test.pro07.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberControllerImpl extends MultiActionController 
	implements MemberController {
	
	@Autowired
	public MemberService memberService;
	
	@Override
	@RequestMapping("/listMembers.do")
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<MemberVO> membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView("listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/addMember.do", 
							method=RequestMethod.POST)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		int result = memberService.addMember(id, pwd, name, email);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.write("<script>");
			out.write("alert('회원 가입에 성공했습니다.');");
			out.write("location.href='/pro07/member/loginForm.do';");
			out.write("</script>");
		} else {
			out.write("<script>");
			out.write("alert('회원 가입에 실패했습니다.');");
			out.write("location.href='/pro07/member/memberForm.do';");
			out.write("</script>");	
		}
		return null;
	}

	@Override
	@RequestMapping("/memberForm.do")
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("memberForm");
	}

	@Override
	@RequestMapping("/memberDetail.do")
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("memberDetail");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		MemberVO member = memberService.memberDetail(id);
		mav.addObject("member", member);
		return mav;
	}

	@Override
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("loginForm");
	}

	@Override
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		int result = memberService.login(id, pwd);
		
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.write("<script>");
			out.write("alert('로그인에 성공했습니다.');");
			out.write("location.href='/pro07/member/listMembers.do';");
			out.write("</script>");
		} else {
			out.write("<script>");
			out.write("alert('로그인에 실패했습니다.');");
			out.write("location.href='/pro07/member/loginForm.do';");
			out.write("</script>");	
		}
		return null;
	}

	@Override
	@RequestMapping("/memberDel.do")
	public ModelAndView memberDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		int result = memberService.memberDel(id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.write("<script>");
			out.write("alert('"+id+"회원님의 정보가 삭제되었습니다.');");
			out.write("location.href='/pro07/member/listMembers.do';");
			out.write("</script>");
		} else {
			out.write("<script>");
			out.write("alert('"+id+"회원님의 정보 삭제에 실패했습니다.');");
			out.write("location.href='/pro07/member/listMembers.do';");
			out.write("</script>");	
		}
		return null;
	}

	@Override
	@RequestMapping("/memberMod.do")
	public ModelAndView memberMod(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		int result = memberService.memberMod(id,pwd,name,email);
		
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.write("<script>");
			out.write("alert('"+id+"회원님의 정보가 수정되었습니다.');");
			out.write("location.href='/pro07/member/listMembers.do';");
			out.write("</script>");
		} else {
			out.write("<script>");
			out.write("alert('"+id+"회원님의 정보 수정에 실패했습니다.');");
			out.write("location.href='/pro07/member/listMembers.do';");
			out.write("</script>");	
		}
		return null;
	}

}



