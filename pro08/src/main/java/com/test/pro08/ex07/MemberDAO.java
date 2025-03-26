package com.test.pro08.ex07;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("memberDAO7")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public void deleteMember(String id) {
		// "mapper.member.deleteMember": MyBatis 매퍼 파일(mapper.xml)에서 정의된 SQL ID
		// id 삭제할 변수 전달
		session.delete("mapper.member.deleteMember", id);
	}
}