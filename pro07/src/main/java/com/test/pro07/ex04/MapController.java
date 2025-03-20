package com.test.pro07.ex04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {
	
	// method=RequestMethod.GET : GET 으로 request 된 것만 처리
	// method= {RequestMethod.GET, RequestMethod.POST}
	// - GET과 POST 둘다 처리 가능
	@RequestMapping(value="/test/login3.do",
			method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(
			// Map<키,값> : 키 - 파라미터이름, 값 - 파라미터 값
			@RequestParam Map<String, String> info,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test/result2");
		
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		
//		mav.addObject("id", id);
//		mav.addObject("name", name);
//		mav.addObject("email", email);
		System.out.println(info.get("id"));
		System.out.println(info.get("name"));
		System.out.println(info.get("email"));
		
		mav.addObject("info", info);
		return mav;
	}
}