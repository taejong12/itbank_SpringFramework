package com.test.pro08.ex04;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO4")
public class MemberDAO {	
	@Autowired
	SqlSession session;
	
	public List<MemberDTO> selectAllMemberList(){
		List<MemberDTO> membersList =
			session.selectList
			("mapper.member.selectAllMemberList");
		return membersList;
	}
	
	public MemberDTO selectMemberById(String id) {
		MemberDTO member = 
				session.selectOne
				("mapper.member.selectMemberById", id);
		return member;
	}
	
	public List<MemberDTO> selectMemberByPwd(String pwd){
		List<MemberDTO> membersList =
			session.selectList
			("mapper.member.selectMemberByPwd", pwd);
		return membersList;
	}
}