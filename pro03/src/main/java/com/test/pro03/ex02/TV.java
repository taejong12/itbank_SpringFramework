package com.test.pro03.ex02;

public class TV {
	public static void main(String[] args) {
		// LG 객체를 생성하고 이를 변수 l에 저장
		LG l = new LG();
		
		// LG 객체의 on() 메서드를 호출하여 "엘지 TV 전원 켜짐"을 출력하는 코드
		l.on();
		
		// Samsung 객체를 생성하고 이를 변수 s에 저장
		Samsung s = new Samsung();
		
		// Samsung 객체의 on() 메서드를 호출하여 "삼성TV 전원 켜짐" 을 출력
		s.on();
		
		// 코드 실행 흐름
		// 1. TV 클래스의 main 메서드가 실행됨
		// 2. LG 객체가 생성되고, l.on(); 이 실행됨
		// 3. LG 클래스의 on() 메서드가 호출되어 "엘지 TV 전원 켜짐"이 출력
		// 4. Samsung 객체가 생성되고, s.on(); 이 실행됨
		// 5. Samsung 클래스의 on() 메서드가 호출되어 "삼성TV 전원 켜짐"이 출력
	}
}