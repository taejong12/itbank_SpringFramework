package com.test.pro07.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.pro07.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	public JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MemberVO> listMembers() {
		// TODO Auto-generated method stub
		String sql = "select * from member order by joinDate desc";
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		
		membersList = this.jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setJoinDate(rs.getDate("joinDate"));
				return m;
			}
			
		});
		return membersList;
	}

	@Override
	public MemberVO memberDetail(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from member where id=?";
		
		MemberVO member = jdbcTemplate.queryForObject(sql, 
				new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MemberVO m = new MemberVO();
				
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setJoinDate(rs.getDate("joinDate"));
				
				return m;
			}
			
		}, id);
		return member;
	}

	@Override
	public int login(String id, String pwd) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from member where id=? and pwd=?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, id, pwd);
		return result;
	}

	@Override
	public int addMember(String id, String pwd, String name, String email) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(?,?,?,?,sysdate)";
		int result = jdbcTemplate.update(sql, id, pwd, name, email);
		return result;
	}

	@Override
	public int memberDel(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from member where id=?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}

	@Override
	public int memberMod(String id, String pwd, String name, String email) {
		// TODO Auto-generated method stub
		String sql = 
			"update member set pwd=?,name=?,email=? where id=?";
		int result = jdbcTemplate.update(sql, pwd, name, email, id);
		
		return result;
	}
	
}









