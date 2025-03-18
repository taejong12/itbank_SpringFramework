package com.test.pro04.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMainAnon {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("AOPTest3.xml");
		LoginAnon lg = (LoginAnon)factory.getBean("loginAnon");
		MemberAnon mb = (MemberAnon)factory.getBean("memberAnon");
		
		lg.loginIn();
		lg.logOut();
		
		mb.memberJoin();
		mb.memberDel();
		
		// 실행 흐름
		// 1. GenericXmlApplicationContext 로 스프링 컨텍스트 로딩
		// 2. AOPTest3.xml 설정 파일을 읽어들여 스프링 컨테이너(factory)를 생성
		// 3. 이 파일에서는 @Component로 정의된 빈들을 관리하고, AOP 기능도 활성화되어 있음
		// 4. getBean("loginAnon"): 스프링 컨테이너에서 loginAnon 이라는 이름의 빈을 가져옴
		// 5. getBean("memberAnon"): 스프링 컨테이너에서 memberAnon 이라는 이름의 빈을 가져옴
		// 6. 각각 LoginAnon 과 MemberAnon 객체를 반환받아 lg, mb 에 할당함
		// 7. lg.loginIn() 호출
		// 8. Around -> 타겟클래스 메서드 실행 전 Around 메서드 실행 
		// 9. Before -> 타켓클래스 메서드 실행 전 Before 메서드 실행
		// 10. loginIn() -> 타겟클래스 메서드 실행
		// 11. After -> 타겟클래스 메서드 실행 후 After 메서드 실행
		// 12. Around -> 타겟클래스 메서드 실행 후 Around 메서드 실행
		// 13. AfterReturning -> 타켓 클래스 메서드 정상적으로 실행 후 AfterReturning 메서드 실행
	}
}