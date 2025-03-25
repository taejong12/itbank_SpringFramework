package com.test.pro08.ex07;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO7")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		session.delete("mapper.member.deleteMember", id);
	}
	
	
}