package com.test.pro04.ex02;

import org.springframework.stereotype.Component;

@Component
public class Member {
	public void memberJoin() {
		System.out.println("회원 가입 중 입니다.");
	}
	public void memberDel() {
		System.out.println("회원 삭제 중 입니다.");
	}
}