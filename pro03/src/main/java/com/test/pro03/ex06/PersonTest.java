package com.test.pro03.ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("person.xml");
		
		PersonService person = 
			(PersonService)factory.getBean("personService");
		person.sayHello();
				
	}
}