package com.test.pro03.ex05;

public class TV {
	static Remote r;
	
	public void setRemote(Remote r) {
		this.r = r;
	}
	
	public static void main(String[] args) {
		TV tv = new TV();
		//tv.setRemote(new Samsung());
		tv.setRemote(new LG());
		tv.r.on();
	}
}