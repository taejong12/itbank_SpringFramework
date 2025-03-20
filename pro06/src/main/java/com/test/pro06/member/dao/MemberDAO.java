package com.test.pro06.member.dao;

import java.util.List;
import com.test.pro06.member.vo.MemberVO;

public interface MemberDAO {
	
	// 회원 목록 조회
	List<MemberVO> listMembers();
	
	// 회원 상세 정보 조회
	MemberVO memberDetail(String id);
	
	// 로그인 처리
	int login(String id, String pwd);
	
	// 회원 추가 (회원 가입)
	int addMember(String id, String pwd, String name, String email);
	
	// 회원 삭제
	int del(String id, String pwd);
	
	// 회원 수정
	int modify(String id, String pwd, String name, String email);
}