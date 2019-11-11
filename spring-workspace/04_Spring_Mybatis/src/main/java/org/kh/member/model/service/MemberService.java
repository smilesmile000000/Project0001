package org.kh.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.kh.member.common.Message;
import org.kh.member.common.SHA256Util;
import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public int updateMember(Member m) {
		return memberDao.updateMember(m);
	}

	@Transactional
	public int insertMember(Member m) {
		return memberDao.insertMember(m);
	}

	public int deleteMember(int memberNo) {
		return memberDao.deleteMember(memberNo);
	}
	
	public Member checkId(String id) {
		System.out.println("checkId메소드 수행시작");
		List list = memberDao.checkId(id);
		if (!list.isEmpty()) {
			return (Member)list.get(0);
	    } else {
	        return null;
	    }
	}

	public ArrayList<Member> selectAllMember() {
		System.out.println("selectAllMember메소드 수행시작");
		List list = memberDao.selectAllMember();
		return (ArrayList<Member>)list;
	}

	
	
	

}
