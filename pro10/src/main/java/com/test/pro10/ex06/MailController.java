package com.test.pro10.ex06;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {
	@Autowired
	MailService service;
	
	@RequestMapping("/test06/sendMail.do")
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out =response.getWriter();
		
		service.sendMail("title", "developertaejong@gmail.com", "contents");
		service.sendPreConfigureMail("contents");
		
		out.print("이메일 발송 완료");
	}
}
