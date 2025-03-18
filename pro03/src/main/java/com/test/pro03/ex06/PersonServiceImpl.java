package com.test.pro03.ex06;

// PersonService 인터페이스를 구현(implements)한 클래스
public class PersonServiceImpl 
		implements PersonService{
	
	// 인스턴스 변수
	private String name;
	private int age;
	
	// setter 메서드 (Spring이 XML 설정을 통해 값을 주입하기 위해 필요함)
	// name 속성의 setter
	public void setName(String name) {
		this.name = name;
	}
	
	// age 속성의 setter
	public void setAge(int age) {
		this.age = age;
	}
	
	// sayHello() 메서드 구현
	public void sayHello() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}