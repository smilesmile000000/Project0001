package org.kh.board.controller;

import java.util.ArrayList;

import org.kh.board.model.service.BoardService;
import org.kh.board.model.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	@Qualifier(value="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/allBoardList.do")
	public ModelAndView allBoardList() {
		ArrayList<Board> list = boardService.selectAllBoard();
		ModelAndView mav = new ModelAndView();
		if(list != null & !list.isEmpty()) {
			mav.addObject("list", list);
			mav.setViewName("board/allBoardList");
		} else {
			mav.setViewName("board/allBoardListError");
		}
		return mav;
	}
	
	@RequestMapping(value="/boardEnrollPage.do")
	public String boardEnrollPage() {
		return "board/boardEnrollPage";
	}
	
	@RequestMapping(value="/boardEnroll.do")
	public String boardEnroll(Board b) {
		int result = boardService.insertBoard(b);
		if(result > 0) {
			return "board/insertSuccess";
		} else {
			return "board/insertFailed";
		}
	}
}
