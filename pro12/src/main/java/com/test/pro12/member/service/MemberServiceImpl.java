package com.test.pro12.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.pro12.member.dao.MemberDAO;
import com.test.pro12.member.dto.MemberDTO;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO dao;
	
	@Override
	public List<MemberDTO> listMembers() {
		// TODO Auto-generated method stub
		return dao.listMembers();
	}

	@Override
	public MemberDTO memberDetail(String id) {
		// TODO Auto-generated method stub
		return dao.memberDetail(id);
	}

	@Override
	public int delMember(String id) {
		// TODO Auto-generated method stub
		return dao.delMember(id);
	}

	@Override
	public int addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return dao.addMember(member);
	}

	@Override
	public int modMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return dao.modMember(member);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		return dao.login(member);
	}

}





