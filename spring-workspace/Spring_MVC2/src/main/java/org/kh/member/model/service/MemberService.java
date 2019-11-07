package org.kh.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {
	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;
	
	public Member selectOneMember(Member m) {
		List list = memberDao.selectOneMember(m);
		Member member = null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		return member;
	}

	public int updateMember(Member m) {
		int result = memberDao.updateMember(m);
		return result;
	}

	public int insertMember(Member m) {
		int result = memberDao.insertMember(m);
		return result;
	}

	public int deleteMember(int memberNo) {
		int result = memberDao.deleteMember(memberNo);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		List list = memberDao.selectAllMember();
		return (ArrayList<Member>)list;
	}

}
