package com.test.pro11.ex04;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	private static Logger logger =
		LoggerFactory.getLogger(BoardController.class);
	
	// 전체글 목록 가져오기
	@RequestMapping(value="all", method=RequestMethod.GET)
	public ResponseEntity<List<ArticleDTO>> 
								listArticles(){
		logger.info("listArticles 메서드 호출");
		List<ArticleDTO> list = 
				new ArrayList<ArticleDTO>();
		
		for(int i=0;i<10;i++) {
			ArticleDTO dto = new ArticleDTO();
			dto.setArticleNo(i);
			dto.setWriter("이순신"+i);
			dto.setTitle("안녕하세요"+i);
			dto.setContent("새로운 상품 입니다"+i);
			list.add(dto);
		}
		
		return new 
			ResponseEntity<List<ArticleDTO>>
				(list,HttpStatus.OK);
	}
	
	// 해당하는 글의 데이터를 가져오기
	@RequestMapping(value="/{articleNo}", 
				method=RequestMethod.GET)
	public ResponseEntity<ArticleDTO> findArticle(
			@PathVariable("articleNo") Integer articleNo){
		logger.info("findArticle 메서드 호출");
		ArticleDTO dto = new ArticleDTO();
		dto.setArticleNo(articleNo);
		dto.setWriter("홍길동");
		dto.setTitle("반갑습니다.");
		dto.setContent("홍길동이 남깁니다.");
		
		return new 
				ResponseEntity<ArticleDTO>
						(dto, HttpStatus.OK);
	}
	
	// 글 저장 하기
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> addArticle
		(@RequestBody ArticleDTO dto) {
		ResponseEntity<String> resEntity = null;
		
		try {
			logger.info("addArticle 메서드 호출");
			logger.info(dto.toString());
			resEntity = new ResponseEntity<String>
				("ADD_SUCCESS", HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			resEntity = new ResponseEntity<String>
			("ADD_FAILED", HttpStatus.BAD_REQUEST); 
			e.printStackTrace();
		}
		return resEntity;
	}
	
	
	// 해당 글을 수정 : 해당 글번호, 수정할 데이터
	@RequestMapping(value="/{articleNo}",
			method=RequestMethod.PUT)
	public ResponseEntity<String> modArticle(
			@PathVariable("articleNo") Integer articleNo,
			@RequestBody ArticleDTO dto) {
		ResponseEntity<String> resEntity = null;
		
		try {
			logger.info("modArticle 메서드 호출");
			logger.info(articleNo + "");
			logger.info(dto.toString());
			resEntity = new ResponseEntity<String>
				("MOD_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			resEntity = new ResponseEntity<String>
			("MOD_FAILED", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resEntity;
	}
	
	// 해당 글을 삭제
	@RequestMapping(value="/{articleNo}",
			method=RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle(
		@PathVariable("articleNo") Integer articleNo){
		ResponseEntity<String> resEntity = null;
		
		try {
			logger.info("removeArticle 메서드 호출");
			logger.info(articleNo + "");
			resEntity = new ResponseEntity<String>
				("DELETE_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>
			("DELETE_FAILED", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resEntity;
	}
}