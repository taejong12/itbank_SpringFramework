package com.test.pro10.ex08;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocaleController {
	
	@RequestMapping("/test08/locale.do")
	public String locale() {
		System.out.println("localeController");
		return "/test08/locale";
	}
}
