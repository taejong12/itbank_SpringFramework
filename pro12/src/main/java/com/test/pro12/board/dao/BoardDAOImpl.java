package com.test.pro12.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pro12.board.dto.ArticleDTO;
import com.test.pro12.board.dto.ImageDTO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ArticleDTO> listArticles() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.board.selectAllArticlesList");
	}

	@Override
	public int selectNewArticleNo() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectNewArticleNo");
	}

	@Override
	public int insertNewArticle(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.board.insertNewArticle", articleMap);
		return (Integer) articleMap.get("articleNo");
	}

	@Override
	public ArticleDTO viewArticle(int articleNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectArticle", articleNo);
	}

	@Override
	public void updateArticle(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int articleNo) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.board.deleteArticle", articleNo);
	}

	@Override
	public int selectNewImageFileNo() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectNewImageFileNo");
	}

	@Override
	public void insertNewImage(List<ImageDTO> imageFileList) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.board.insertNewImage", imageFileList);
	}

	@Override
	public List<ImageDTO> selectImageFileList(int articleNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.board.selectImageFileList", articleNo);
	}

	@Override
	public int deleteImage(int imageFileNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("mapper.board.deleteImage", imageFileNo);
	}

	@Override
	public int selectArticleNo(int imageFileNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectArticleNo", imageFileNo);
	}

}





