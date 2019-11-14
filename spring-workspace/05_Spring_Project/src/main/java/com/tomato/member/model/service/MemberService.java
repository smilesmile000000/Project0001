package com.tomato.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tomato.member.model.dao.MemberDao;
import com.tomato.member.model.vo.Member;

@Service("memberService")
public class MemberService {
	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;
	
	public MemberService() {
		super();
	}
	
	public Member selectOneMember(Member m) {
		return memberDao.selectOneMember(m);
	}

}
