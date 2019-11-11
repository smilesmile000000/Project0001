/*package org.kh.board.model.dao;

import java.util.List;

import org.kh.board.model.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

	public int boardUpdate(Board b) {
		String query = "update board set board_title=?, board_content=? where board_no=?";
		int result = jdbcTemplate.update(query, b.getBoardTitle(), b.getBoardContent(), b.getBoardNo());
		return result;
	}

	public List boardUpdatePage(int boardNo) {
		String query = "select * from board where board_No=?";
		Object[] params = {boardNo};
		return jdbcTemplate.query(query, params, new BoardRowMapper());
	}

}
*/