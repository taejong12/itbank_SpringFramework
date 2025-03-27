package com.test.pro10.ex06;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	// 이메일을 전송하는 역할
	@Autowired
	private JavaMailSender mailSender;
	// 미리 설정된 수신자 정보를 가진 이메일 메시지
	@Autowired
	private SimpleMailMessage preConfigureMessage;
	
	public void sendMail(String title, String to, String contents) {
		
		// HTML 본문을 포함한 이메일을 보낼 수 있는 MimeMessage 객체 생성
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// MimeMessageHelper -> 첨부파일 및 HTML 형식 이메일을 지원하는 도우미 클래스
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			// 참조(참고 수신) 이메일 주소 -> 참조 이메일 설정 (수신자가 아닌 참고용)
			messageHelper.setCc("test@naver.com");
			// 송신자이메일주소, 송신자이름 -> 발신자 이메일과 발신자 이름 설정
			messageHelper.setFrom("admintest@naver.com", "관리자");
			// 이메일 제목 -> 이메일 제목 설정
			messageHelper.setSubject(title);
			// 수신자 이메일 주소 -> 수신자 이메일 설정
			messageHelper.setTo(to);
			// 이메일 본문 -> 이메일 본문 설정
			messageHelper.setText(contents);
			// 이메일 전송 실행
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 미리 설정된 수신자로 이메일 전송
	public void sendPreConfigureMail(String contents) {
		// 미리 설정된 정보를 가진 이메일 객체 생성
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfigureMessage);
		// 본문만 변경 가능
		mailMessage.setText(contents);
		// 이메일 발송
		mailSender.send(mailMessage);
	}
}