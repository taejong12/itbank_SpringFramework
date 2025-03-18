package com.test.pro03.ex03;

public class LG implements Remote{
	// LG 클래스는 Remote 인터페이스를 Implements(구현)함
	// 메서드 필수 구현
	public void on() {
		System.out.println("엘지 TV 전원 켜짐");
	}
}