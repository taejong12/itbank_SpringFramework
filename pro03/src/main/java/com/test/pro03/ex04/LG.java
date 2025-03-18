package com.test.pro03.ex04;

public class LG implements Remote{
	// LG 클래스는 Remote 인터페이스를 implements 하여 on() 메서드를 구현함
	public void on() {
		System.out.println("엘지 TV 전원 켜짐");
	}
}