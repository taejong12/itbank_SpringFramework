package com.test.pro08.ex02;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDAO2")
public class MemberDAO {
	// MyBatis가 제공하는 핵심 객체
	// sqlSession을 통해 매퍼 XML에 정의한 SQL을 실행할 수 있음
	@Autowired
	SqlSession sqlSession;
	
	public String selectId() {
		// mapper.member.selectId -> mapper/member.xml 에서 정의된 id="selectId" SQL 문을 실행
		// selectOne() -> 결과가 1개 나오는 SQL 실행
		String id = sqlSession.selectOne("mapper.member.selectId");
		return id;
	}

	public int selectCount() {
		// mapper.member.selectCount => mapper/member.xml에서 정의된 id="selectCount" SQL 실행
		int cnt = sqlSession.selectOne("mapper.member.selectCount");
		return cnt;
	}
}