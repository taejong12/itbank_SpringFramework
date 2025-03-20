package com.test.pro06.member.service;

import java.util.List;
import com.test.pro06.member.dao.MemberDAO;
import com.test.pro06.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	public MemberDAO memberDAO;
	
	 
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	// 회원 목록 조회
	public List<MemberVO> listMembers() {
		return memberDAO.listMembers();
	}
	
	// 회원 상세 정보 조회
	public MemberVO memberDetail(String id) {
		return memberDAO.memberDetail(id);
	}

	// 로그인 처리
	public int login(String id, String pwd) {
		return memberDAO.login(id, pwd);
	}

	// 회원 추가 (회원 가입)
	public int addMember(String id, String pwd, String name, String email) {
		return memberDAO.addMember(id,pwd,name,email);
	}

	// 회원 삭제 
	public int del(String id, String pwd) {
		return memberDAO.del(id, pwd);
	}

	// 회원 수정
	public int modify(String id, String pwd, String name, String email) {
		return memberDAO.modify(id,pwd,name,email);
	}
}
