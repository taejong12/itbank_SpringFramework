package com.test.pro12.board.dao;

import java.util.List;
import java.util.Map;

import com.test.pro12.board.dto.ArticleDTO;
import com.test.pro12.board.dto.ImageDTO;


public interface BoardDAO {

	List<ArticleDTO> listArticles();
	int selectNewArticleNo();
	int insertNewArticle(Map<String, Object> articleMap);
	ArticleDTO viewArticle(int articleNo);
	void updateArticle(Map<String, Object> articleMap);
	void deleteArticle(int articleNo);
	int selectNewImageFileNo();
	void insertNewImage(List<ImageDTO> imageFileList);
	List<ImageDTO> selectImageFileList(int articleNo);
	int deleteImage(int imageFileNo);
	int selectArticleNo(int imageFileNo);

}