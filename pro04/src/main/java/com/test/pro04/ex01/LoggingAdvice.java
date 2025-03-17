package com.test.pro04.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// Advice 클래스 : AOP 실행 클래스
// implements MethodInterceptor 
public class LoggingAdvice 
			implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[메서드 호출전 : LoggingAdvice]");
		System.out.println(invocation.getMethod() 
				+ " 메서드 호출전");
		
		Object obj = invocation.proceed();
		
		System.out.println("[메서드 호출후 : LoggingAdvice]");
		System.out.println(invocation.getMethod() 
				+ " 메서드 호출후");
		return obj;
	}

}