package com.test.pro04.ex02;

import org.aspectj.lang.ProceedingJoinPoint;

public class AOPAdvice {
	public void aopMethodBefore() {
		System.out.println("[메서드 실행전 AOP 실행]");
	}
	public void aopMethodAfter() {
		System.out.println("= 메서드 실행후 AOP 실행 =");
	}
	public Object aopMethodAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		
		System.out.println("%% 메서드 실행전 AOP 실행 %%");
		result = pjp.proceed();
		System.out.println("%% 메서드 실행후 AOP 실행 %%");
		
		return result;
	}
	public void aopMethodReturn() {
		System.out.println("~~ 메서드 정상 종료 후 AOP 실행 ~~");	
	}
}





