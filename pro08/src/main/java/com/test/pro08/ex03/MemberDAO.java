package com.test.pro08.ex03;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro08.ex01.MemberDTO;

@Repository("memberDAO3")
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	public List<MemberDTO> selectAllMemberMap(){
		List<MemberDTO> membersList =
				session.selectList("mapper.member.selectAllMemberMap");
		return membersList;
	}
	
}






