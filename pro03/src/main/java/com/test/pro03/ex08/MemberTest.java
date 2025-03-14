package com.test.pro03.ex08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberTest {
	public static void main(String[] args) {
		AbstractApplicationContext factory =
			new GenericXmlApplicationContext("member.xml");
		MemberService service = 
			(MemberService)factory.getBean("memberService");
		service.listMembers();
	}
}