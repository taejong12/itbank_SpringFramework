package com.test.pro11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JSONTestController2 {
	
	@RequestMapping(value = "/JSON2", method = RequestMethod.GET)
	public String home() {
		return "JSONTest2";
	}
}