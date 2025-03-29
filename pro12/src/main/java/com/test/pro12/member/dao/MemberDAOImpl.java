package com.test.pro12.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro12.member.dto.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> listMembers() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.member.listMembers");
	}

	@Override
	public MemberDTO memberDetail(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.member.memberDetail", id);
	}

	@Override
	public int delMember(String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete("mapper.member.delMember", id);
	}

	@Override
	public int addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.member.addMember", member);
	}

	@Override
	public int modMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return sqlSession.update("mapper.member.modMember", member);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.member.login", member);
	}

}







