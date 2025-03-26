package com.test.pro08.quiz04;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository
public class Quiz04DAO {
	@Autowired
	SqlSession session;

	public MemberDTO selectMemberById(String id) {
		MemberDTO member =
			session.selectOne
				("mapper.quiz.selectMemberById", id);
		return member;
	}

	public MemberDTO selectMemberIdPwd(MemberDTO m) {
		MemberDTO member =
			session.selectOne
				("mapper.quiz.selectMemberIdPwd", m);
		return member;
	}
}