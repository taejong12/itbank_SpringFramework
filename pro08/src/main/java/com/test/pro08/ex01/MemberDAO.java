package com.test.pro08.ex01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * sqlSession.selectList = select을 실행 후 List 로 가져옴
 * sqlSession.selectOne = select을 실행 후 한개의 레코드를 가져옴
 * sqlSession.selectMap = select을 실행 후 Map 타입으로 가져옴
 * sqlSession.insert = insert문 실행  
 * sqlSession.update = update문 실행
 * sqlSession.delete = delete문 실행
 */
@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberDTO> selectAllList() {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = 
			sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}
}
