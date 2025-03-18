package com.test.pro04.ex01;

// Target 클래스 : AOP 적용 클래스
// AOP 없이 호출하면 단순히 연산 결과만 출력됨
// AOP 적용 후 호출하면 LoggingAdvice 가 실행되고 로그를 찍은 뒤에 연산이 수행됨
// Spring이 자동으로 AOP 프록시를 적용해서 메서드 실행 전후로 로깅 기능을 추가해줌
public class Calculator {
	public void add(int x, int y) {
		System.out.println("결과 : " + (x + y));
	}
	public void substract(int x, int y) {
		System.out.println("결과 : " + (x - y));
	}
	public void multiply(int x, int y) {
		System.out.println("결과 : " + (x * y));
	}
	public void divide(int x, int y) {
		System.out.println("결과 : " + (x / y));
	}
}