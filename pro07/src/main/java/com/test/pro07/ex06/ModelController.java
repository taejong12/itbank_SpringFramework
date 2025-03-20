package com.test.pro07.ex06;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.pro07.ex03.MemberDTO;


@Controller
public class ModelController {
	// @Model : ModelAndView에서 Model 역할이다. 데이터 전송 역할이다.
	// @Model 을 사용할 때는 String 으로 View 페이지를 지정한다.
	@RequestMapping("/test/login5.do")
	public String login(
			Model model,
			@ModelAttribute() MemberDTO member,
			HttpServletRequest request, 
			HttpServletResponse response) {
		model.addAttribute("id", member.getId());
		model.addAttribute("name", member.getName());
		model.addAttribute("email", member.getEmail());
		
		return "/test/result";
	}
}