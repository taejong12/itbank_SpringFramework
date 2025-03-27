package com.test.pro11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JSONTestController5 {
	
	@RequestMapping(value = "/JSON5", method = RequestMethod.GET)
	public String home() {
		return "JSONTest5";
	}
}