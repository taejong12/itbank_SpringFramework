package com.test.pro07.ex07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro07.ex03.MemberDTO;

@Repository
public class AutoDAO {
	@Autowired
	MemberDTO member;
	
	public MemberDTO selectMember() {
		member.setId("hong");
		member.setPwd("1234");
		member.setName("홍길동");
		member.setEmail("hong@test.com");
		return member;
	}
}