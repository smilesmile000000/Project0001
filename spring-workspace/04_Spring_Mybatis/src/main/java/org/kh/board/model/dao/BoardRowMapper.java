/*package org.kh.board.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.board.model.vo.Board;
import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int arg1) throws SQLException {
		Board b = new Board();
		b.setBoardNo(rset.getInt("board_no"));
		b.setBoardTitle(rset.getString("board_title"));
		b.setBoardAuthor(rset.getString("board_author"));
		b.setBoardContent(rset.getString("board_content"));
		b.setBoardEnrollDate(rset.getDate("board_enroll_date"));
		return b;
	}
}
*/