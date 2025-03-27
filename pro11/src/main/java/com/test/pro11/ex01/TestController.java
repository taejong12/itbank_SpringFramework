package com.test.pro11.ex01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 이 클래스가 REST API 컨트롤러라는 것을 의미
// 일반적인 @Controller와 달리, 
// 메서드에서 반환하는 문자열이 HTML이 아니라 그대로 응답 데이터가 됨
@RestController

// 이 컨트롤러 내부의 모든 URL은 /test/로 시작함
// * 는 와일드 카드로, /test/ 뒤에 어떤 값이 와도 매칭될 수 있음
@RequestMapping("/test/*")
public class TestController {

	// 클라이언트가 /test/hello 로 GET 요청을 보내면 이 메서드가 실행됨
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST";
	}
}