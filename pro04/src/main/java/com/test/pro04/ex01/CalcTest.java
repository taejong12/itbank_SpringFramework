package com.test.pro04.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcTest {
	public static void main(String[] args) {
		// AOPTest.xml 설정 파일을 로드하여 Spring 컨테이너 생성
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("AOPTest.xml");
		
		// "proxyCal" 이라는 AOP 프록시 객체를 calculator 타입으로 가져옴
		// AOP(로깅) 적용된 프록시 객체 -> AOP 기능(LoggingAdvice)을 포함
		Calculator cal = (Calculator) factory.getBean("proxyCal");
		cal.add(100, 20);
		System.out.println();
		cal.substract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);
		
		// 실행 흐름
		// 1. GenericXmlApplicationContext("AOPTest.xml") 실행
		// 2. "calcTarget" (원본 Calculator)과 "logAdvice" (LoggingAdvice) 객체 생성
		// 3. "proxyCal" (AOP 프록시 객체) 생성
		// 4. factory.getBean("proxyCal")을 호출하면 AOP 적용된 프록시 객체를 반환
		// 5. proxyCal.add(100, 20) 호출
		// 6. LoggingAdvice.invoke() 실행
		// 7. "add(100, 20)" 메서드 실행 전에 로깅 출력
		// 8. 원본 Calculator.add(100, 20) 실행
		// 9. "add(100, 20)" 메서드 실행 후에 로깅 출력
	}
}