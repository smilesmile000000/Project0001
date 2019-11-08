package org.kh.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.kh.member.common.Message;
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
	
	public MemberService() {
		super();
	}
	
	public Member selectOneMember(Member m) {
		System.out.println("selectOneMember메소드 수행시작");
		List list = memberDao.selectOneMember(m);
		Member member = null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		return member;
	}

	public int updateMember(Member m) {
		System.out.println("updateMember메소드 수행시작");
		int result = memberDao.updateMember(m);
		return result;
	}

	public int insertMember(Member m) {
		System.out.println("insertMember 수행시작");
		int result = memberDao.insertMember(m);
		return result;
	}

	public int deleteMember(int memberNo) {
		System.out.println("deleteMember메소드 수행시작");
		int result = memberDao.deleteMember(memberNo);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		System.out.println("selectAllMember메소드 수행시작");
		List list = memberDao.selectAllMember();
		return (ArrayList<Member>)list;
	}

	public void test() {
		
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
	
	

}
