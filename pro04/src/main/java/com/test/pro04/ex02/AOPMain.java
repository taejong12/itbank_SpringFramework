package com.test.pro04.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("AOPTest2.xml");
		
		Login lg = (Login)factory.getBean("login");
		Member mb = (Member)factory.getBean("member");
		
		lg.loginIn();
		lg.logOut();
		
		mb.memberJoin();
		mb.memberDel();
	}
}