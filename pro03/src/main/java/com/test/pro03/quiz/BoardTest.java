package com.test.pro03.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 생성 (board.xml 파일 로드)
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("board.xml");
		
		// 2. boardService Bean 가져오기 (의존성 주입 완료된 상태)
		BoardService service = (BoardService)factory.getBean("boardService");
		
		// 3. 게시글 목록 조회 실행
		service.listBoard();
		
		// 실행 흐름
		// 1. new GenericXmlApplicationContext("board.xml") 실행
		// 2. Spring 컨테이너가 board.xml을 로드
		// 3. boardDAO 객체 생성
		// 4. boardService 객체 생성 + boardDAO를 생성자로 주입
		// 5. factory.getBean("boardService") 실행
		// 6. BoardServiceImpl 객체를 가져옴
		// 7. service.listBoard(); 실행
		// 8. BoardServiceImpl.listBoard() -> BoardDAOImpl.listBoard() 호출
	}
}