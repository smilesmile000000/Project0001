package org.kh.board.model.dao;

import java.util.List;

import org.kh.board.model.vo.Board;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

@Repository("boardDao")
public class BoardDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List selectAllBoard() {
		String query = "select * from board";
		List list = jdbcTemplate.query(query, new BoardRowMapper());
		return list;
	}

	public int insertBoard(Board b) {
		String query = "insert into board values(board_no_seq.nextval, ?, ?, ?, sysdate)";
		int result = jdbcTemplate.update(query, b.getBoardTitle(), b.getBoardAuthor(), b.getBoardContent());
		return result;
	}

}
