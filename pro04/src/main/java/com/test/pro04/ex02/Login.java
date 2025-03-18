package com.test.pro04.ex02;

import org.springframework.stereotype.Component;

// @Component: 스프링이 관리해주는 빈(객체)으로 등록
@Component
public class Login {
	public void loginIn() {
		System.out.println("로그인 중 입니다.");
	}
	public void logOut() {
		System.out.println("로그 아웃 중 입니다.");
	}
}