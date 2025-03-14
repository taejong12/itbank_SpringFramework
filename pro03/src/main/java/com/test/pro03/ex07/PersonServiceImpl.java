package com.test.pro03.ex07;

public class PersonServiceImpl 
		implements PersonService{
	private String name;
	private int age;
	
	public PersonServiceImpl(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public PersonServiceImpl(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
	
	public PersonServiceImpl(int age, String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
	
	public void sayHello() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}