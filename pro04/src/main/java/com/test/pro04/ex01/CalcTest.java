package com.test.pro04.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("AOPTest.xml");
		Calculator cal = 
			(Calculator) factory.getBean("proxyCal");
		cal.add(100, 20);
		System.out.println();
		cal.substract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);
	}
}