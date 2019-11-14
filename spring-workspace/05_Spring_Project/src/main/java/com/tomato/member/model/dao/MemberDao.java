package com.tomato.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tomato.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember", m);
	}

}
