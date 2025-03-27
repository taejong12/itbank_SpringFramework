package com.test.pro11.ex02;

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
@RequestMapping("/test")
public class TestController2 {
	@RequestMapping("/member")
	public MemberDTO member() {
		MemberDTO dto = new MemberDTO();
		dto.setId("hong");
		dto.setPwd("1234");
		dto.setName("홍길동");
		dto.setEmail("hong@test.com");
		return dto;
	}
	
	@RequestMapping("/membersList") 
	public List<MemberDTO> membersList(){
		List<MemberDTO> list = 
				new ArrayList<MemberDTO>();
		
		for(int i=0;i<10;i++) {
			MemberDTO dto = new MemberDTO();
			dto.setId("hong"+i);
			dto.setPwd("1234");
			dto.setName("홍길동"+i);
			dto.setEmail("hong"+i+"@test.com");
			list.add(dto);
		}
		
		return list;
	}
	
	@RequestMapping("/membersMap")
	public Map<Integer, MemberDTO> membersMap(){
		Map<Integer, MemberDTO> map =
				new HashMap<Integer, MemberDTO>();
		
		for (int i=0;i<10;i++) {
			MemberDTO dto = new MemberDTO();
			dto.setId("hong"+i);
			dto.setPwd("1234");
			dto.setName("홍길동"+i);
			dto.setEmail("hong"+i+"@test.com");
			map.put(i, dto);
		}
		return map;
	}
	
	// @PathVariable() : 경로의 값을 매개변수로 사용
	// 브라우저에서 요청 시 {num} 부분의 값이 @PathVariable 로 지정됨
	// 요청 URL에서 지정된 값이 num에 자동으로 할당됨
	@RequestMapping("/notice/{num}")
	public int notice(@PathVariable("num") int num) {
		return num;
	}
	
	// Spring 에서 @RequestBody 는 클라이언트가 보낸 JSON 데이터를 Java 객체로 변환해주는 역할
	// HTTP 요청 본문(body)에 담긴 데이터를 MemberDTO 객체로 변환해 컨트롤러의 매개변수로 전달해줌
	@RequestMapping("/info")
	public void modify(@RequestBody MemberDTO dto) {
		System.out.println(dto.toString());
	}
	
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