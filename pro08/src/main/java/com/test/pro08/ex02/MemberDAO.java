package com.test.pro08.ex02;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDAO2")
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public String selectId() {
		// TODO Auto-generated method stub
		String id = sqlSession.selectOne("mapper.member.selectId");
		return id;
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		int cnt = sqlSession.selectOne("mapper.member.selectCount");
		return cnt;
	}

}








