package com.test.pro12.member.service;

import java.util.List;

import com.test.pro12.member.dto.MemberDTO;


public interface MemberService {
	List<MemberDTO> listMembers();
	MemberDTO memberDetail(String id);
	int delMember(String id);
	int addMember(MemberDTO member);
	int modMember(MemberDTO member);
	MemberDTO login(MemberDTO member);
}