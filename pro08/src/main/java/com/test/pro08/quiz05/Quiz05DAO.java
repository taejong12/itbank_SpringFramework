package com.test.pro08.quiz05;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository
public class Quiz05DAO {
	@Autowired
	SqlSession session;


	public List<MemberDTO> selectEmail(MemberDTO m) {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList =
			session.selectList("mapper.member.selectEmail", m);
		return membersList;
	}
	
	
}