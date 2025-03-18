package com.test.pro03.ex07;

public class PersonServiceImpl implements PersonService{
	private String name;
	private int age;
	
	// 1. 생성자 오버로딩
	// 여러 개의 생성자가 정의되어 있음
	// 같은 클래스라도 생성자에 전달하는 값의 순서에 따라 다르게 동작할 수 있음
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public PersonServiceImpl(int age, String name) {
		this.name = name;
		this.age = age;
	}
	
	public void sayHello() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}