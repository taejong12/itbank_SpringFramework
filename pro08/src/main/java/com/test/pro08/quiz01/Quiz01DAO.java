package com.test.pro08.quiz01;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository
public class Quiz01DAO {
	@Autowired
	SqlSession sqlSession;
	
	public MemberDTO selectMember() {
		MemberDTO member = 
			sqlSession.selectOne("mapper.quiz.selectMember");
		return member;
	}
}