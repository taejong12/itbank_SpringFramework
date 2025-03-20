package com.test.pro06.member.vo;

import java.sql.Date;

// Value Object (VO) 클래스
// 1. 일반적으로 데이터베이스의 테이블과 1:1 매핑되는 객체로 사용됨
// 2. 특정 엔티티에 대한 데이터를 캡슐화하여 제공하는 역할
// 3. MemberVO는 member 테이블의 각 열을 객체의 속성으로 가지게 됨
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}