package com.test.pro12.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.pro12.board.dao.BoardDAO;
import com.test.pro12.board.dto.ArticleDTO;
import com.test.pro12.board.dto.ImageDTO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<ArticleDTO> listArticles() {
		// TODO Auto-generated method stub
		return dao.listArticles();
	}

	@Override
	public int addNewArticle(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		int articleNo = dao.selectNewArticleNo();
		articleMap.put("articleNo", articleNo);
		int result = dao.insertNewArticle(articleMap);
		
		List<ImageDTO> imageFileList = 
				(List<ImageDTO>) articleMap.get("imageFileList");
		int imageFileNo = dao.selectNewImageFileNo();
		
		for(ImageDTO imageDTO : imageFileList) {
			imageDTO.setImageFileNo(++imageFileNo);
			imageDTO.setArticleNo(articleNo);
		}
		
		dao.insertNewImage(imageFileList);
		return result;
	}

	@Override
	public Map viewArticle(int articleNo) {
		// TODO Auto-generated method stub
		Map articleMap = new HashMap();
		ArticleDTO articleDTO = dao.viewArticle(articleNo);
		List<ImageDTO> imageFileList = dao.selectImageFileList(articleNo);
		
		articleMap.put("article", articleDTO);
		articleMap.put("imageFileList", imageFileList);
		return articleMap;
	}

	@Override
	public void modArticle(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		List<ImageDTO> imageFileList = 
				(List<ImageDTO>) articleMap.get("imageFileList");
		int imageFileNo = dao.selectNewImageFileNo();
		dao.updateArticle(articleMap);
		for(ImageDTO imageDTO : imageFileList) {
			imageDTO.setImageFileNo(++imageFileNo);
		}
		dao.insertNewImage(imageFileList);
	}

	@Override
	public void removeArticle(int articleNo) {
		// TODO Auto-generated method stub
		dao.deleteArticle(articleNo);
	}

	@Override
	public int deleteImage(int imageFileNo) {
		// TODO Auto-generated method stub
		int articleNo = dao.selectArticleNo(imageFileNo);
		dao.deleteImage(imageFileNo);
		return articleNo;
	}

}






