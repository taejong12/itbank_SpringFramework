package com.test.pro10.ex07;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class MailService2 {
	@Autowired
	private JavaMailSender mailSender;
	
	// 해당 메일이 보내는 중에도 컴퓨터가 멈추지 않음
	@Async
	public void sendMail(String title, String to, String contents) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			// 참조이메일주소
			messageHelper.setCc("test@naver.com");
			// 송신자이메일주소, 송신자이름
			messageHelper.setFrom("admintest@naver.com", "관리자");
			messageHelper.setSubject(title);
			messageHelper.setTo(to);
			// true: HTML 태그 적용
			messageHelper.setText(contents, true);
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
