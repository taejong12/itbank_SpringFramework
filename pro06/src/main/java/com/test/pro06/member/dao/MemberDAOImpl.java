package com.test.pro06.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.test.pro06.member.vo.MemberVO;


public class MemberDAOImpl implements MemberDAO{
	
	public JdbcTemplate jdbcTemplate;
	
	// dataSource를 사용하여 JdbcTemplate 객체를 수동으로 생성
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 회원 목록 조회
	public List<MemberVO> listMembers() {
		String sql = "select * from member order by joinDate desc";
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		
		// 1. query() => SELECT 쿼리 실행
		// 2. SQL 쿼리 결과를 목록으로 반환할 때 사용
		// 3. RowMapper를 사용하여 ResultSet을 객체로 매핑함
		//	(RowMapper: ResultSet의 각 행을 객체로 변환하는 역할)
		// 4. 반환값: SQL 쿼리 결과를 매핑한 객체의 리스트
		membersList = this.jdbcTemplate.query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
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

	// 회원 상세 정보 조회
	public MemberVO memberDetail(String id) {
	    String sql = "SELECT * FROM member WHERE id = ?";
	    
	    // 1. queryForObject() => 단일 결과 조회
	    // 2. SELECT 쿼리 결과가 한 개일 때 사용됨 (예: 특정 ID의 회원 조회)
	    // 3. RowMapper: ResultSet을 객체로 반환
	    // 4. 반환값: 단일 객체 (하나의 행에 해당하는 데이터)
	    MemberVO member = jdbcTemplate.queryForObject(sql, new RowMapper<MemberVO>(){
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
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

	// 로그인 처리
	public int login(String id, String pwd) {
		String sql = "select count(*) from member where id=? and pwd=? ";
		
		// 1. 단일 컬럼 조회
		// 2. SQL 쿼리 결과가 단일 컬럼(예: COUNT와 같은 집계 함수)일 때 사용
		// 3. Integer.class: 반환될 데이터 타입
		// 4. 반환값: 쿼리 실행 결과로 얻은 단일 값 (여기서는 int 형)
		int result = jdbcTemplate.queryForObject(sql, Integer.class,id,pwd);
		return result;
	}

	// 회원 추가 (회원 가입)
	public int addMember(String id, String pwd, String name, String email) {
		String sql = "insert into member values(?,?,?,?,sysdate)";
		
		// 1. update() => INSERT, UPDATE, DELETE 쿼리 실행
		// 2. 데이터 변경 작업을 수행할 때 사용
		// 3. 매개변수: SQL 쿼리의 ?(id, pwd, name, email) 자리에 매핑할 값들
		// 4. 반환값: 쿼리 실행 후 변경된 행의 수
		int result = jdbcTemplate.update(sql,id,pwd,name,email);
		return result;
	}

	// 회원 삭제
	public int del(String id, String pwd) {
		String sql = "delete from member where id = ? and pwd = ?";
		
		// 1. update() => DELETE 쿼리 실행
		// 2. 매개변수: SQL 쿼리의 ?(id, pwd) 자리에 매핑할 값들
		// 3. 반환값: 변경된 행의 수
		int result = jdbcTemplate.update(sql,id, pwd);
		return result;
	}

	// 회원 수정
	public int modify(String id, String pwd, String name, String email) {
		String sql = "update member set pwd =?, name=?, email=? where id = ? ";
		
		// 1. update() => UPDATE 쿼리 실행
		// 2. 매개변수: SQL 쿼리의 ?(id, pwd, name, email) 자리에 매핑할 값들
		// 3. 반환값: 변경된 행의 수
		int result = jdbcTemplate.update(sql,pwd,name,email,id);
		return result;
	}
}
