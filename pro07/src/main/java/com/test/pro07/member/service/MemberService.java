package com.test.pro07.member.service;

import java.util.List;

import com.test.pro07.member.vo.MemberVO;

public interface MemberService {

	List<MemberVO> listMembers();
	MemberVO memberDetail(String id);
	int login(String id, String pwd);
	int addMember(String id, String pwd, String name, String email);
	int memberDel(String id);
	int memberMod(String id, String pwd, String name, String email);

}