package com.test.pro08.ex06;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO6")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public void updateMember(MemberDTO m) {
		// "mapper.member.updateMember": MyBatis 매퍼 파일(mapper.xml)에서 정의된 SQL ID
		// m 수정할 회원 정보 객체 전달
		session.update("mapper.member.updateMember", m);
	}
}