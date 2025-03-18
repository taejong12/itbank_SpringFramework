package com.test.pro03.ex09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LazyTest {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 생성 (lazy.xml 파일 로드)
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("lazy.xml");
		
		// 2. "Second Bean 호출" 출력
		System.out.println("Second Bean 호출");
		
		// 3. "secondBean" 을 직접 요청 -> 이 때, "Second" 객체가 생성됨
		factory.getBean("secondBean");
		
		// 실행 흐름
		// 1. new GenericXmlApplicationContext("lazy.xml") 실행
		// 2. 즉시 생성되는 Bean: firstBean, thirdBean -> 생성자 호출
		// 3. secondBean은 lazy-init="true" 이므로 아직 생성이 안 됨
		// 4. "Second Bean 호출" 입력
		// 5. factory.getBean("secondBean") 호출 -> 이제야 Second 객체 생성됨
	}
}