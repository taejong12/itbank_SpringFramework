package com.test.pro08.ex06;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO6")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public void updateMember(MemberDTO m) {
		// TODO Auto-generated method stub
		int result = 
			session.update("mapper.member.updateMember", m);
	}
	
	
}