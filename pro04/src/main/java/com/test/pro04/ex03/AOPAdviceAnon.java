package com.test.pro04.ex03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPAdviceAnon {
	@Before("execution(* com.test.pro04.ex03.*.*(..))")
	public void aopMethodBefore() {
		System.out.println("실행전 Anon AOP 실행");
	}
	@After("execution(* com.test.pro04.ex03.*.*(..))")
	public void aopMethodAfter() {
		System.out.println("실행후 Anon AOP 실행");
	}
	@Around("execution(* com.test.pro04.ex03.*.*(..))")
	public Object aopMethodAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		
		System.out.println("Around Anon 실행전 AOP 실행");
		result = pjp.proceed();
		System.out.println("Around Anon 실행후 AOP 실행");
		
		return result;
	}
	@AfterReturning("execution(* com.test.pro04.ex03.Login*.*n*(..)) || "
			+ "execution(* com.test.pro04.ex03.Member*.*n*(..))")
	public void aopMethodReturn () {
		System.out.println("메서드가 정상 종료 후 AOP 실행");
	}
}