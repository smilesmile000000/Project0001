package org.kh.member.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class Message {
	public void printMessage() {
		System.out.println("[공통로드] - 비지니스 로직 수행전 동작 1번");
	}
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] : 비지니스 메소드 수행 전 동작");
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER] : 비지니스 메소드 수행 후 동작");
		return returnObj;
	}
}
