package com.test.pro03.ex03;

public class TV {
	public static void main(String[] args) {
		// LG 객체가 생성되어 l 변수에 저장됨
		// l 은 Remote 타입이지만, 실제로는 LG 객체를 가리킴(다형성)
		Remote l = new LG();
		
		// Samsung 객체가 생성되어 s 변수에 저장됨
		// s 는 Remote 타입이지만, 실제로는 Samsung 객체를 가리킴(다형성)
		Remote s = new Samsung();
		
		// LG 클래스의 on() 메서드가 호출됨
		l.on();
		
		// Samsung 클래스의 on() 메서드가 호출됨
		s.on();
	}
}