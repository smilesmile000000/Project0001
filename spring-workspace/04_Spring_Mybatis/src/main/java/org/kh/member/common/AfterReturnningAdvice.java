package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.kh.member.model.vo.Member;

public class AfterReturnningAdvice {
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
