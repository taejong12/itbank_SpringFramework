package com.test.pro03.ex07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("person2.xml");
		
		PersonService person1 = 
			(PersonService)factory.getBean("personService1");
		person1.sayHello();
		PersonService person2 = 
			(PersonService)factory.getBean("personService2");
		person2.sayHello();
				
	}
}