package com.test.pro04.ex03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect: advice + pointcut
// AOP의 핵심인 Aspect를 정의하기 위해 사용
// AOP 기능을 수행하는 Aspect 역할
// Aspect는 공통 관심사(cross-cutting concerns)를 정의하는 클래스
// AOP에서는 이 공통 관심사를 별도로 분리하여 관리하기 위해 Aspect를 사용
// AOP 관련 설정을 이 클래스에서 정의
// Advice(실제 공통 로직)는 Aspect 내부에 구현되고, Poincut(어떤 메서드에 AOP를 적용할지 지정하는 조건)은 Aspect 내부에 정의
@Aspect

// @Component 어노테이션
// Spring IoC 컨테이너에 이 클래스를 빈(Bean)으로 등록하기 위해 사용
// @Component가 붙은 클래스는 Spring의 자동 빈 등록 기능을 이용해 객체로 관리됨
// 이 객체는 스프링 컨테이너에 의해 관리되고, 
// 의존성 주입(Dependency Injection)을 통해 다른 클래스에서 사용할 수 있음
@Component

// @Aspect + @Component의 결합
// @Aspect는 이 클래스가 AOP 역할을 한다는 것을 나타내고, 
// @Component는 이 클래스가 Spring의 빈으로 관리된다는 것을 의미함
// AOP 클래스는 스프링 컨테이너에서 빈으로 관리되며, AOP 기능을 수행할 수 있음
public class AOPAdviceAnon {
	
	// 1. 포인트컷(Pointcut)
	// 어떤 메서드에 AOP를 적용할지 범위(대상)를 지정하는 것
	// "execution(...)" 이 부분이 포인트컷
	// 2. 어드바이스(Advice)
	// 언제 (before, after 등) 무슨 코드를 실행할지 정의하는 부분
	// @Before, @After, @Around, @AfterReturning, @AfterThrowing 등이 어드바이스 종류
	
	// @Before: 모든 메서드 실행 전 실행
	@Before("execution(* com.test.pro04.ex03.*.*(..))")
	public void aopMethodBefore() {
		System.out.println("실행전 Anon AOP Before 실행");
	}
	
	// @After: 모든 메서드 실행 후 실행
	@After("execution(* com.test.pro04.ex03.*.*(..))")
	public void aopMethodAfter() {
		System.out.println("실행후 Anon AOP After 실행");
	}
	
	// @Around: 메서드 실행 전/후로 감싸서 실행
	@Around("execution(* com.test.pro04.ex03.*.*(..))")
	public Object aopMethodAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		System.out.println("실행전 Anon AOP Around 실행");
		result = pjp.proceed();
		System.out.println("실행후 Anon AOP Around 실행");
		return result;
	}
	
	// @AfterReturning: 메서드가 정상적으로 끝났을 때만 실행
	@AfterReturning("execution(* com.test.pro04.ex03.Login*.*n*(..)) || execution(* com.test.pro04.ex03.Member*.*n*(..))")
	public void aopMethodReturn () {
		System.out.println("메서드 정상 종료 후 AOP AfterReturning 실행");
	}
}