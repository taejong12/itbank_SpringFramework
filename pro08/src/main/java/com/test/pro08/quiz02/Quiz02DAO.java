package com.test.pro08.quiz02;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository
public class Quiz02DAO {
	@Autowired
	SqlSession session;

	public String selectName(String id) {
		String name = session.selectOne
				("mapper.quiz.selectName", id);
		return name;
	}

	public int loginCheck(String id, String pwd) {
		MemberDTO m = new MemberDTO();
		m.setId(id);
		m.setPwd(pwd);
		int result = session.selectOne
				("mapper.quiz.loginCheck", m);
		return result;
	}
}