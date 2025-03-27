package com.test.pro11.ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController3 {
	
	@RequestMapping("/membersList2")
	public ResponseEntity<MemberDTO> membersList2(){
		List<MemberDTO> list = 
				new ArrayList<MemberDTO>();
		for (int i=0;i<10;i++) {
			MemberDTO dto = new MemberDTO();
			dto.setId("hong"+i);
			dto.setPwd("1234");
			dto.setName("홍길동"+i);
			dto.setEmail("hong"+i+"@test.com");
			list.add(dto);
		}
		
		// HTTP 응답을 캡슐화하는 객체
		// list -> 응답 본문 (클라이언트에게 반환할 데이터, 예: JSON, 문자열 등)
		// HttpStatus.INTERNAL_SERVER_ERROR -> 응답 상태 코드 (500 - 서버 내부 오류)
		// 이 코드는 HTTP 500 상태 코드와 함께 list 데이터를 응답으로 반환하는 것
		// 변환가능 -> return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(list);
		return new ResponseEntity
			(list, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("/res3")
	public ResponseEntity res3() {
		HttpHeaders responseHeaders =
				new HttpHeaders();
		responseHeaders.add("Content-Type", 
					"text/html;charset=utf-8");
		String message = "<script>";
		message +="alert('새 회원을 등록합니다.');";
		message +="location.href='/pro11/test/membersList2';";
		message +="</script>";
		return new ResponseEntity(message, 
				responseHeaders, HttpStatus.CREATED);
	}
}