package com.test.pro03.ex07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 생성 (XML 파일 로드)
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("person2.xml");
		
		// 2. personService1 Bean 가져오기
		PersonService person1 = (PersonService)factory.getBean("personService1");
		person1.sayHello();
		
		// 3. personService2 Bean 가져오기
		PersonService person2 = (PersonService)factory.getBean("personService2");
		person2.sayHello();
		
		// 실행흐름
		// 1. Spring 컨테이너 생성 -> person2.xml을 읽어와서 Bean을 생성하고 관리함
		// 2. Bean 가져오기 ->  id="personService1" 로 설정된 "이순신" 값을 가지는 객체 생성 (age는 기본값 0)
		// 3. Bean 가져오기 ->  id="personService2" 로 설정된 age=25, name="김유신" 값을 가지는 객체 생성
		// 4. person1.sayHello(); -> name="이순신", age=0(기본값)
		// 5. person2.sayHello(); -> name="김유신", age=25
	}
}