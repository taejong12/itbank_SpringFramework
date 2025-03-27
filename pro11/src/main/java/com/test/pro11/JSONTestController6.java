package com.test.pro11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JSONTestController6 {
	
	@RequestMapping(value = "/JSON6", method = RequestMethod.GET)
	public String home() {
		return "JSONTest6";
	}
}