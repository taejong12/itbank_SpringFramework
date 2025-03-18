package com.test.pro03.ex03;

public class Samsung implements Remote{
	// Samsung 클래스는 Remote 인터페이스를 implements 함
	// on() 메서드를 오버라이딩하여 "삼성TV 전원 켜짐"을 출력
	public void on() {
		System.out.println("삼성TV 전원 켜짐");
	}
}