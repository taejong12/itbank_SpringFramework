package com.test.pro04.quiz;


public class BoardServiceImpl implements BoardService {
	BoardDAO boardDAO;
	
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public void listBoard() {
		boardDAO.listBoard();
	}
}
