package com.test.pro03.ex08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberTest {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 생성 (member.xml 로드)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("member.xml");
		
		// 2. memberService Bean 가져오기
		MemberService service = (MemberService)factory.getBean("memberService");
		
		// 3. listMembers() 메서드 호출
		service.listMembers();
		
		// 실행 흐름
		// 1. Spring 컨테이너를 생성 -> member.xml을 읽어와서 Bean을 생성하고 관리함
		// 2. Bean 가져오기 -> memberService 객체를 가져옴 (내부적으로 memberDAO가 자동으로 주입되어 있음)
		// 3. 회원 조회 실행 -> MemberServiceImpl.listMembers() 실행 -> MemberDAOImpl.listMembers()가 호출됨
	}
}