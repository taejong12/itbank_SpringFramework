package com.test.pro04.quiz;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BoardAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("로그인 확인 메서드");
		
		Object obj = invocation.proceed();
		
		System.out.println("데이터 확인 메서드");
		
		return obj;
	}
	
	@Before("execution(* com.test.pro04.quiz.BoardServiceImpl.*(..))")
	public void boardBefore() {
		System.out.println("[메서드 실행 전 AOP 실행]");
	}
	
	@After("execution(* com.test.pro04.quiz.BoardDAOImpl.*(..))")
	public void boardAfter() {
		System.out.println("#메서드 실행 후 AOP 실행#");
	}
}