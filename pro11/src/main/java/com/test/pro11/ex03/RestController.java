package com.test.pro11.ex03;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestController {
	
	@RequestMapping("/res1")
	
	// Spring MVC에서 컨트롤러 메서드의 반환 값을 HTTP 응답 본문(body)으로 
	// 직접 변환하여 클라이언트에 전달하는 역할
	// 1. JSON 또는 문자열 데이터를 클라이언트로 직접 응답할 때 사용
	// 2. 뷰(jsp, thymeleaf 등)를 반환하지 않고 데이터만 전송할 때 사용
	// 3. REST API를 만들 때 필수적으로 사용
	@ResponseBody
	public Map<String, Object> res1(){
		Map<String, Object> map
			= new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "홍길동");
		// Map 데이터를 브라우저로 전송
		return map;
	}

	@RequestMapping("/res2")
	public ModelAndView res2() {
		return new ModelAndView("home");
	}
}