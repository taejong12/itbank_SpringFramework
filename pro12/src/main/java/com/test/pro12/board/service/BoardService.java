package com.test.pro12.board.service;

import java.util.List;
import java.util.Map;

import com.test.pro12.board.dto.ArticleDTO;


public interface BoardService {

	List<ArticleDTO> listArticles();
	int addNewArticle(Map<String, Object> articleMap);
	Map viewArticle(int articleNo);
	void modArticle(Map<String, Object> articleMap);
	void removeArticle(int articleNo);
	int deleteImage(int imageFileNo);

}