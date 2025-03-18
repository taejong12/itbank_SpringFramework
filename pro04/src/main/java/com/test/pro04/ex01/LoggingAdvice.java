package com.test.pro04.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// Advice 클래스 : AOP 실행 클래스
// AOP에서 보조 기능을 담당하는 Advice 클래스
// MethodInterceptor 인터페이스를 구현해서 메서드 실행 전/후에 로그를 출력할 수 있음
public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출전 : LoggingAdvice]");
		// 현재 실행되는 메서드 정보를 가져와서 로그로 출력
		System.out.println(invocation.getMethod() + " 메서드 호출전");
		
		// invocation.proceed()를 호출해야 원래 대상(Calculator)의 메서드가 실행됨
		Object obj = invocation.proceed();
		
		System.out.println("[메서드 호출후 : LoggingAdvice]");
		System.out.println(invocation.getMethod() + " 메서드 호출후");
		return obj;
	}

}