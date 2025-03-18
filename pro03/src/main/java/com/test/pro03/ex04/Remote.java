package com.test.pro03.ex04;

public interface Remote {
	// 인터페이스는 구현이 없는 메서드만 포함할 수 있음
	// 이를 구현하는 클래스는 on() 메서드를 반드시 구현해야 함
	public void on();
}