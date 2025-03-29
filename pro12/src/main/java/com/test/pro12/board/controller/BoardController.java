package com.test.pro12.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro12.board.dto.ImageDTO;


public interface BoardController {
	public ModelAndView listArticles(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ModelAndView form(
			@RequestParam(value="parentNo", required = true) Integer parentNo,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ResponseEntity addNewArticle(MultipartHttpServletRequest mRequest,
			HttpServletResponse response) throws Exception;
	public ModelAndView viewArticle(
			@RequestParam("articleNo") int articleNo,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ResponseEntity modArticle(MultipartHttpServletRequest mRequest,
			HttpServletResponse response) throws Exception;
	public ResponseEntity removeArticle(
			@RequestParam("articleNo") int articleNo,
			HttpServletRequest Request,
			HttpServletResponse response) throws Exception;
	public ResponseEntity deleteImage(
			@RequestParam("image") ImageDTO image,
			HttpServletRequest mRequest,
			HttpServletResponse response) throws Exception;
}