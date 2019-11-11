package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MemberPass {
	@Autowired
	@Qualifier("SHA256Util")
	private SHA256Util sha256util;
	
	@Pointcut("execution(* org.kh.member.model.service..*Service.*(org.kh.member.model.vo.Member))")
	public void encPass() {}
	
	@Before("encPass()")
	public void passwordEnc(JoinPoint jp) throws Exception{
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		String password = m.getMemberPw();
		if(!password.isEmpty()) {
			String encPassword = sha256util.encData(password);
			m.setMemberPw(encPassword);
		}
	}
}
