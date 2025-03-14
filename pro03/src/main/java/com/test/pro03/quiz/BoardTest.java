package com.test.pro03.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =
		new GenericXmlApplicationContext("board.xml");
		
		BoardService service =
		(BoardService)factory.getBean("boardService");
		
		service.listBoard();
	}
}