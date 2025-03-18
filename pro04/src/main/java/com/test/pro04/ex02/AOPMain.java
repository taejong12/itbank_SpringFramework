package com.test.pro04.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMain {
	public static void main(String[] args) {
		// AOPTest2.xml 파일을 읽어서 스프링 컨테이너 실행
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("AOPTest2.xml");
		
		// Login, Member 빈 가져와서 메서드 호출 -> 이 때 AOP가 작동
		Login lg = (Login)factory.getBean("login");
		Member mb = (Member)factory.getBean("member");
		
		// 메서드마다 AOPAdvice에서 정의한 공통 기능이 끼어들어 실행됨
		lg.loginIn();
		lg.logOut();
		
		mb.memberJoin();
		mb.memberDel();
		
		// 실행 흐름
		// 1. GenericXmlApplicationContext factory = new GenericXmlApplicationContext("AOPTest2.xml");
		// 2. 스프링 컨테이너가 실행되고, AOPTest2.xml 설정을 읽음
		// 3. @Component 붙은 Login, Member 객체와 AOPAdvice 객체 생성
		// 4. AOP 설정대로 프록시 객체가 만들어짐 -> 실제 Login, Member 가 아닌 프록시가 주입됨
		// 5. Login lg = (Login)factory.getBean("login");
		// 6. Login 클래스의 프록시 객체가 반환됨 (AOP가 적용된 형태)
		// 7. Member mb = (Member)factory.getBean("member");
		// 8. Member 클래스의 프록시 객체가 반환됨
		// 9. lg.loginIn(); 호출
		// 10. AOP 프록시가 가로챔
		// 11. Before Advice 실행
		// 12. Around Advice - 전처리
		// 13. 실제 Login.loginIn() 실행
		// 14. Around Advice - 후처리
		// 15. After Advice 실행
		// 16. After-Returning Advice (메서드명에 'n'이 있어서 실행)
		// 17. logOut() 에는 'n'이 없으므로 after-returning은 생략
		
		
	}
}