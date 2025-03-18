package com.test.pro03.ex04;

public class TV {
	private Remote r;
	
	// 생성자에서 Remote 타입의 객체를 받음
	public TV(Remote r) {
		this.r = r;
	}
	
	public static void main(String[] args) {
		// LG 객체를 생성해서 TV 클래스에 전달
		TV l = new TV(new LG());
		
		// Samsung 객체를 생성해서 TV 클래스에 전달
		TV s = new TV(new Samsung());
		
		l.r.on();
		s.r.on();
	}
}