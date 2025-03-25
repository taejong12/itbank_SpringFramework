package com.test.pro10.ex06;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage preConfigureMessage;
	
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
			messageHelper.setText(contents);
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendPreConfigureMail(String contents) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfigureMessage);
		mailMessage.setText(contents);
		mailSender.send(mailMessage);
	}

}
