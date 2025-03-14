package com.test.pro03.ex09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LazyTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("lazy.xml");
		System.out.println("Second Bean 호출");
		factory.getBean("secondBean");
	}
}