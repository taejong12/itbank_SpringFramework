package com.test.pro08.ex08;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO8")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public List<MemberDTO> searchMember(MemberDTO m) {
		List<MemberDTO> membersList =
			session.selectList
				("mapper.member.searchMember", m);
		return membersList;
	}

	public List<MemberDTO> searchMember2(MemberDTO m) {
		List<MemberDTO> membersList =
			session.selectList
				("mapper.member.searchMember2", m);
		return membersList;
	}

	public List<MemberDTO> foreachSelect(List<String> nameList) {
		List<MemberDTO> membersList =
			session.selectList
				("mapper.member.foreachSelect", nameList);
		return membersList;
	}
}