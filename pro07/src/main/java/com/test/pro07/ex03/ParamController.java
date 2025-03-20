package com.test.pro07.ex03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {
	@RequestMapping("/test/login2.do")
	public ModelAndView login2(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/test/result");
		
		// @RequestParam("파라미터키") 데이터타입 변수이름
		// String id = request.getParameter("id"); String name =
		// request.getParameter("name");
		
		mav.addObject("id", id);
		mav.addObject("name", name);
		
		return mav;
	}
	
}