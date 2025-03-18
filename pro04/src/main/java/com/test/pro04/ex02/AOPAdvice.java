package com.test.pro04.ex02;

import org.aspectj.lang.ProceedingJoinPoint;

// AOP에서 사용할 공통 기능(Advice)을 정의한 클래스
// @Before, @After, @Around, @AfterReturning 에서 실행될 메서드들
// ProceedingJoinPoint: 실제 핵심 기능(타켓 메서드)을 실행시킬 수 있도록 도와주는 객체 (Around에서만 사용)
public class AOPAdvice {
	// 메서드 실행 전 실행
	public void aopMethodBefore() {
		System.out.println("==== 메서드 실행전 AOP Before 실행 ====");
	}
	// 메서드 실행 후 실행 (성공/실패 관계없음)
	public void aopMethodAfter() {
		System.out.println("==== 메서드 실행후 AOP After 실행 ====");
	}
	// 메서드 실행 전후 모두 실행 (중앙에서 감쌈)
	public Object aopMethodAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		System.out.println("%% 메서드 실행전 AOP Around 실행 %%");
		result = pjp.proceed();
		System.out.println("%% 메서드 실행후 AOP Around 실행 %%");
		System.out.println();
		return result;
	}
	// 메서드가 정상 종료했을 때만 실행
	public void aopMethodReturn() {
		System.out.println("~~ 메서드 정상 종료 후 AOP After-Returning 실행 ~~");
		System.out.println();
	}
}




