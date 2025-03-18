package com.test.pro03.ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 생성 (XML 파일 로드)
		GenericXmlApplicationContext factory =
			new GenericXmlApplicationContext("person.xml");
		
		// 2. personService 빈(bean) 가져오기
		PersonService person = 
			(PersonService)factory.getBean("personService");
		
		// 3. sayHello() 실행
		person.sayHello();
		
		// 실행 흐름
		// 1. Spring 컨테이너 생성 -> person.xml 을 읽어와서 Bean을 생성하고 관리함
		// 2. Bean 가져오기 -> id="personService" 로 설정된 PersonServiceImpl 객체를 가져옴
		// 3. 메서드 실행 -> sayHello() 실행 -> "이름 : 홍길동", "나이 20" 출력
				
	}
}