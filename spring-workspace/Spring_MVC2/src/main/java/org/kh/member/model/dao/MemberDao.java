package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List selectOneMember(Member m) {
		System.out.println("jdbcTemplate : " + jdbcTemplate);
		// 1. query(PreparedStatement), param 배열, RowMapper
		String query = "select * from member where member_id=? and member_pw=?";
		Object [] params = {m.getMemberId(), m.getMemberPw()};
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		return list;
	}


	public int updateMember(Member m) {
		String query = "update member set member_pw=?, member_name=?, member_addr=? where member_no=?";
		int result = jdbcTemplate.update(query, m.getMemberPw(), m.getMemberName(), m.getMemberAddr(), m.getMemberNo());
		return result;
	}


	public int insertMember(Member m) {
		String query = "insert into member values(member_seq.nextval, ?, ?, ?, ?, sysdate)";
		int result = jdbcTemplate.update(query, m.getMemberId(), m.getMemberPw(), m.getMemberName(), m.getMemberAddr());
		return result;
	}


	public int deleteMember(int memberNo) {
		String query = "delete member where member_no=?";
		int result = jdbcTemplate.update(query, memberNo);
		return result;
	}

	public List selectAllMember() {
		String query = "select * from member";
		List list = jdbcTemplate.query(query,  new MemberRowMapper());
		return list;
	}

//	public void test() {
//		String query = "select count(*) from member";
//		int count = jdbcTemplate.queryForObject(query, int.class);
//	}
}
