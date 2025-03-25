package com.test.pro08.ex05;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO5")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public int insertMember(MemberDTO m) {
		// TODO Auto-generated method stub
		int result = 
			session.insert
				("mapper.member.insertMember", m);
		return result;
	}

	public List<MemberDTO> listMembers() {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = 
			session.selectList
				("mapper.member.selectAllMemberList");
		return membersList;
	}
}