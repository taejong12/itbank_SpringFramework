package com.test.pro08.quiz03;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository()
public class Quiz03DAO {
	@Autowired
	SqlSession session;

	public int insertMember(Map<String, String> m) {
		int result = 
			session.insert
				("mapper.quiz.insertMemberMap", m);
		return result;
	}

	public List<MemberDTO> listMembers() {
		List<MemberDTO> membersList = 
			session.selectList
				("mapper.quiz.selectAllMemberList");
		return membersList;
	}
}