package com.test.pro03.ex08;

// MemberService 구현클래스
public class MemberServiceImpl implements MemberService{
	// MemberDAO를 직접 생성하지 않고, Spring 컨테이너가 자동으로 주입하도록 설정함
	// 1. 결합도를 낮출 수 있음(약한 결합)
	// 		MemberServiceImpl이 MemberDAOImpl을 직접 생성하지 않음
	// 		다른 DAO 구현체로 쉽게 변경 가능
	// 2. Spring 컨테이너가 객체를 관리
	// 		개발자가 new 키워드로 객체를 직접 생성하지 않아도 됨
	//		유지보수가 쉬워짐
	private MemberDAO memberDAO;
	
	// Setter 주입 (Setter Injection) (Spring에서 주입할 대상)
	// XML 설정에서 <property> 태그를 사용하여 Setter 메서드를 통해 객체를 주입함
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
}