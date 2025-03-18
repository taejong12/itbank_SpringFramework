package com.test.pro03.ex08;

// MemberDAO 인터페이스를 구현하는 클래스
public class MemberDAOImpl implements MemberDAO{

	// 회원정보를 조회하는 로직을 수행
	@Override
	public void listMembers() {
		System.out.println("listMembers 메서드 호출");
		System.out.println("회원정보를 조회합니다.");
	}
}