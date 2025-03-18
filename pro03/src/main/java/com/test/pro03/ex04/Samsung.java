package com.test.pro03.ex04;

public class Samsung implements Remote{
	// Samsung 클래스도 Remote 인터페이스를 implements 하여 on() 메서드를 구현함
	public void on() {
		System.out.println("삼성TV 전원 켜짐");
	}
}