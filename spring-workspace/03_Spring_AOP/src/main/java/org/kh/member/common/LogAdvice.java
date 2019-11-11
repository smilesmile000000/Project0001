package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* org.kh.member.model.service..*Service.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void brforeLog() {
		System.out.println("[BeforeLog]-메소드 수행 전 동작 ");
	}
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		System.out.println(methodName + "() 메소드 수행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
	@AfterReturning(pointcut="allPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		// 호출한 메소드 이름
		String methodName = jp.getSignature().getName();
		if(returnObj instanceof Member) {
			// returnObj의 타입이 Member이면 true
			Member m = (Member)returnObj;
			System.out.println("[" + m.getMemberName() + "]님이 로그인 하였습니다");
		}
		System.out.println("[AfterLog] 호출 메소드 : " + methodName);
	}
}
