package com.test.pro04.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMainAnon {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("AOPTest3.xml");
		
		LoginAnon lg = (LoginAnon)factory.getBean("loginAnon");
		MemberAnon mb = (MemberAnon)factory.getBean("memberAnon");
		
		lg.loginIn();
		lg.logOut();
		
		mb.memberJoin();
		mb.memberDel();
	}
}