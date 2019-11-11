package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	public Member selectOneMember(Member m) {
//		System.out.println("jdbcTemplate : " + jdbcTemplate);
		// 1. query(PreparedStatement), param 배열, RowMapper
		return sqlSession.selectOne("member.selectOneMember", m);
	}


	public int updateMember(Member m) {
		return sqlSession.update("member.updateMember", m);
	}


	public int insertMember(Member m) {
		return sqlSession.insert("member.insertMember", m);
	}

	public int deleteMember(int memberNo) {
		return sqlSession.delete("member.deleteMember", memberNo);
	}
	
	public List checkId(String id) {
		return sqlSession.selectList("member.checkId", id);
	}

	public List selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}

	
	
}
