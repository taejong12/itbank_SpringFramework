package com.test.pro03.quiz;

// BoardService 구현 클래스
public class BoardServiceImpl implements BoardService {
	// 생성자 주입
	BoardDAO boardDAO;
	
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public void listBoard() {
		boardDAO.listBoard();
	}
}