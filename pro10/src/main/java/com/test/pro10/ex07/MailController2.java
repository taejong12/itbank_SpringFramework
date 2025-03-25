package com.test.pro10.ex07;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController2 {
	@Autowired
	MailService2 service2;
	
	@RequestMapping("/test07/sendMail.do")
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out =response.getWriter();
		
		String msg = "<html><body>";
		msg += "<h1>내 강아지 보여줄게</h1>";
		msg += "<img src='https://cdn.lecturernews.com/news/photo/202203/93345_312029_1841.jpg'><br>";
		msg += "더 많은 사진은 <a href='https://www.zooseyo.or.kr/zooseyo_or_kr.html?'>여기를</a> 클릭";
		msg += "</html></body>";
		
		service2.sendMail("분양받을래?", "dbxowhdsla12@naver.com", msg);
		
		out.print("메일이 전송 되었습니다.");
	}
}
