package com.test.pro04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext factory =new GenericXmlApplicationContext("boardAOP2.xml");
		
		BoardService service = (BoardService) factory.getBean("boardService");
		
		service.listBoard();
	}
}