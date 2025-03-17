package com.test.pro04.ex01;

// Target 클래스 : AOP 적용 클래스
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