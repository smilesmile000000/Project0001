package org.kh.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.kh.board.model.dao.BoardDao;
import org.kh.board.model.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardService {
	@Autowired
	@Qualifier("boardDao")
	private BoardDao boardDao;
	
	public ArrayList<Board> selectAllBoard() {
		List list  = boardDao.selectAllBoard();
		return (ArrayList<Board>)list;
	}

	public int insertBoard(Board b) {
		int result = boardDao.insertBoard(b);
		return result;
	}

	public int boardUpdate(Board b) {
		int result = boardDao.boardUpdate(b);
		return result;
	}

	public Board boardUpdatePage(int boardNo) {
		List list = boardDao.boardUpdatePage(boardNo);
		Board board = null;
		
		if(!list.isEmpty()) {
			board = (Board)list.get(0);
		}
		return board;
	}

}
