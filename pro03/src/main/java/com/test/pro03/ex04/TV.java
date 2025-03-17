package com.test.pro03.ex04;

public class TV {
	static Remote r;
	
	public TV(Remote r) {
		this.r = r;
	}
	
	public static void main(String[] args) {
//		TV tv = new TV(new LG());
		TV tv = new TV(new Samsung());
		tv.r.on();
	}
}