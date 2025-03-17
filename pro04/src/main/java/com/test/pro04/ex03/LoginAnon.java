package com.test.pro04.ex03;

import org.springframework.stereotype.Component;

@Component
public class LoginAnon {
	public void loginIn() {
		System.out.println("로그인 중 입니다.");
	}
	public void logOut() {
		System.out.println("로그 아웃 중 입니다.");
	}
}