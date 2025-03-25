package com.test.pro10.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

// 이 클래스가 AOP(관전 지향 프로그래밍, Aspect-Oriented Programming)에서 Aspect(횡단 관심사) 역할을 한다는 것을 의미
// 횡단 관심사(Cross-Cutting Concern): 여러 클래스에서 반복적으로 사용되는 기능 (ex:로깅, 트랜잭션, 보안 검사 등)
@Aspect
public class LogAdvice {
	
	// SLF4J를 이용해 LogAdvice 클래스에 대한 로그 기록 객체를 생성
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	// JoinPoint jp 객체를 통해 메서드 실행 정보(메서드명, 매개변수, 대상 객체 등)를 가져올 수 있음
	@Before("execution(* com.test.pro10.ex02.*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("==== Before ====");
		// 메서드의 매개변수 값
		logger.info("1: "+ Arrays.deepToString(jp.getArgs()));
		// 실행 종류 (method execution)
		logger.info("2: "+ jp.getKind());
		// 실행되는 메서드 이름
		logger.info("3: "+ jp.getSignature().getName());
		// 실제 호출 대상 객체
		logger.info("4: "+ jp.getTarget().toString());
		// 프록시 객체 (AOP 적용된 객체)
		logger.info("5: "+ jp.getThis().toString());
		logger.info("");
		
	}
	
	@After("execution(* com.test.pro10.ex02.*.*(..))")
	public void endLog(JoinPoint jp) {
		logger.info("==== After ====");
		logger.info("1: "+ Arrays.deepToString(jp.getArgs()));
		logger.info("2: "+ jp.getKind());
		logger.info("3: "+ jp.getSignature().getName());
		logger.info("4: "+ jp.getTarget().toString());
		logger.info("5: "+ jp.getThis().toString());
		logger.info("");
		
	}
	
	// ProceedingJoinPoint pjp 객체를 사용하면 메서드 실행을 직접 제어할 수 있음
	@Around("execution(* com.test.pro10.ex02.*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		logger.info("==== Around Before ====");
		logger.info("1: "+ Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		
		logger.info("2: "+ pjp.getSignature().getName());
		
		logger.info("==== Around After ====");
		long endTime = System.currentTimeMillis();
		logger.info("동작시간 : "+ (endTime - startTime) + "ms");
		return result;
		
	}
}
