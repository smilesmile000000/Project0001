package org.kh.board.model.vo;

import java.sql.Date;

public class Board {
	private int BoardNo;
	private String BoardTitle;
	private String BoardAuthor;
	private String BoardContent;
	private Date BoardEnrollDate;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String boardTitle, String boardAuthor, String boardContent, Date boardEnrollDate) {
		super();
		BoardNo = boardNo;
		BoardTitle = boardTitle;
		BoardAuthor = boardAuthor;
		BoardContent = boardContent;
		BoardEnrollDate = boardEnrollDate;
	}
	public int getBoardNo() {
		return BoardNo;
	}
	public void setBoardNo(int boardNo) {
		BoardNo = boardNo;
	}
	public String getBoardTitle() {
		return BoardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}
	public String getBoardAuthor() {
		return BoardAuthor;
	}
	public void setBoardAuthor(String boardAuthor) {
		BoardAuthor = boardAuthor;
	}
	public String getBoardContent() {
		return BoardContent;
	}
	public void setBoardContent(String boardContent) {
		BoardContent = boardContent;
	}
	public Date getBoardEnrollDate() {
		return BoardEnrollDate;
	}
	public void setBoardEnrollDate(Date boardEnrollDate) {
		BoardEnrollDate = boardEnrollDate;
	}
	
	
}
