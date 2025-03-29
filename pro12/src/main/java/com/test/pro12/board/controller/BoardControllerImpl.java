package com.test.pro12.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.pro12.board.dto.ArticleDTO;
import com.test.pro12.board.dto.ImageDTO;
import com.test.pro12.board.service.BoardService;


@Controller
@RequestMapping("/board")
@EnableTransactionManagement
public class BoardControllerImpl implements BoardController {
	private static final String BOARD_REPO = "C:\\Users\\dbxow\\image";
	@Autowired
	private BoardService service;
	
	@Override
	@RequestMapping("/listArticles.do")
	public ModelAndView listArticles(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		List<ArticleDTO> articlesList = service.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
	}

	@Override
	@RequestMapping("/*Form.do")
	public ModelAndView form(
			Integer parentNo,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("parentNo", parentNo);
		return mav;
	}

	@Override
	@RequestMapping(value="/addNewArticle", method=RequestMethod.POST)
	public ResponseEntity addNewArticle(MultipartHttpServletRequest mRequest, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		mRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration<String> enu = mRequest.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = mRequest.getParameter(name);
			articleMap.put(name, value);
		}
		
		// String imageFileName = upload(mRequest);
		List<String> fileList = upload(mRequest);
		List<ImageDTO> imageFileList = new ArrayList<ImageDTO>();
		
		if(fileList != null && fileList.size() != 0) {
			for(String fileName : fileList) {
				ImageDTO image = new ImageDTO();
				image.setImageFileName(fileName);
				imageFileList.add(image);
			}
			articleMap.put("imageFileList", imageFileList);
		}
		
		HttpSession session = mRequest.getSession();
		String id = (String)session.getAttribute("loginId");
		
		if(articleMap.get("parentNo") == null) {
			articleMap.put("parentNo", 0);
		} else {
			int parentNo = Integer.parseInt((String) articleMap.get("parentNo"));
			articleMap.put("parentNo", parentNo);
		}
		
		articleMap.put("id", id);
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		try {
			int articleNo = service.addNewArticle(articleMap);
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageDTO imageDTO : imageFileList) {
					File srcFile = 
							new File(BOARD_REPO + "\\" + "temp" + "\\" 
									+ imageDTO.getImageFileName());
					File destDir = new File(BOARD_REPO + "\\" + articleNo);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			message = "<script>";
			message += "alert('새글을 추가했습니다.');";
			message += "location.href='/pro12/board/listArticles.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageDTO imageDTO : imageFileList) {
					File srcFile = 
							new File(BOARD_REPO + "\\" + "temp" + "\\" 
									+ imageDTO.getImageFileName());
					srcFile.delete();
				}
			}
			message = "<script>";
			message += "alert('오류가 발생했습니다. 다시 시도해 주세요');";
			message += "location.href='/pro12/board/articleForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	private List<String> upload(MultipartHttpServletRequest mRequest) throws IOException {
		// TODO Auto-generated method stub
		// String imageFileName = null;
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = mRequest.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = mRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			fileList.add(originalFileName);
			
			File file = new File(BOARD_REPO + "\\" + fileName);
			
			if(mFile.getSize() != 0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(BOARD_REPO + "\\" + "temp" 
						+ "\\" + originalFileName));
			}
		}
		return fileList;
	}

	@Override
	@RequestMapping("/viewArticle.do")
	public ModelAndView viewArticle(
			@RequestParam("articleNo") int articleNo,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		Map articleMap = service.viewArticle(articleNo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articleMap", articleMap);
		return mav;
	}

	@Override
	@RequestMapping(value="/modArticle.do", method=RequestMethod.POST)
	public ResponseEntity modArticle(MultipartHttpServletRequest mRequest, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		mRequest.setCharacterEncoding("utf-8");
		Map<String , Object> articleMap = new HashMap<String, Object>();
		
		String articleNo = mRequest.getParameter("articleNo");
		articleMap.put("articleNo", articleNo);
		
		String title = mRequest.getParameter("title");
		articleMap.put("title", title);
		
		String content = mRequest.getParameter("content");
		articleMap.put("content", content);
		
		// String imageFileName = upload(mRequest);
		List<String> fileList = upload(mRequest);
		List<ImageDTO> imageFileList = new ArrayList<ImageDTO>();
		if(fileList != null && fileList.size() != 0) {
			for(String fileName:fileList) {
				ImageDTO imageDTO = new ImageDTO();
				imageDTO.setImageFileName(fileName);
				imageDTO.setArticleNo
					(Integer.parseInt((String) articleMap.get("articleNo")));
				imageFileList.add(imageDTO);
			}
			articleMap.put("imageFileList", imageFileList);
		}
		
		HttpSession session = mRequest.getSession();
				
		String id = (String)session.getAttribute("loginId");
		articleMap.put("id", id);
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		try {
			service.modArticle(articleMap);
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageDTO imageDTO: imageFileList) {
					File srcFile = 
							new File(BOARD_REPO + "\\" + "temp" + "\\" 
									+ imageDTO.getImageFileName());
					File destDir = new File(BOARD_REPO + "\\" + articleNo);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			message = "<script>";
			message += "alert('글이 수정 되었습니다.');";
			message += "location.href='/pro12/board/viewArticle.do?articleNo="
					+articleNo+"';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageDTO imageDTO : imageFileList) {
					File srcFile = 
							new File(BOARD_REPO + "\\" + "temp" + "\\" 
									+ imageDTO.getImageFileName());
					srcFile.delete();
				}
			}
			message = "<script>";
			message += "alert('수정 중 오류가 발생했습니다. 다시 시도해 주세요');";
			message += "location.href='/pro12/board/viewArticle.do?articleNo="
					+articleNo+"';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		
		return resEnt;
	}

	@Override
	@RequestMapping(value="/removeArticle.do", method=RequestMethod.POST)
	public ResponseEntity removeArticle(int articleNo, HttpServletRequest Request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String message = null;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		try {
			service.removeArticle(articleNo);
			File destDir = new File(BOARD_REPO + "\\" + articleNo);
			FileUtils.deleteDirectory(destDir);
			
			message = "<script>";
			message += "alert('삭제가 완료되었습니다.');";
			message += "location.href='/pro12/board/listArticles.do;";
			message += "</script>";
			resEnt = new  ResponseEntity(message, responseHeaders, HttpStatus.OK);
		} catch(Exception e) {
			message = "<script>";
			message += "alert('삭제에 실패했습니다. 다시 시도해 주세요.');";
			message += "location.href='/pro12/board/listArticles.do;";
			message += "</script>";
			resEnt = new  ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		
		return resEnt;
	}

	@Override
	@RequestMapping("/deleteImage.do")
	public ResponseEntity deleteImage(
			ImageDTO image, 
			HttpServletRequest mRequest, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		int articleNo = service.deleteImage(image.getImageFileNo());
		String message = null;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		try {
			File deleteFile = new File(BOARD_REPO + "\\" + articleNo + "\\" 
					+ image.getImageFileName());
			deleteFile.delete();
			
			message = "<script>";
			message += "alert('삭제가 완료되었습니다.');";
			message += "location.href='/pro12/board/viewArticle.do?articleNo="
					+articleNo+"';";
			message += "</script>";
			resEnt = new  ResponseEntity(message, responseHeaders, HttpStatus.OK);
		} catch(Exception e) {
			message = "<script>";
			message += "alert('삭제에 실패했습니다. 다시 시도해 주세요.');";
			message += "location.href='/pro12/board/viewArticle.do?articleNo="
					+articleNo+"';";
			message += "</script>";
			resEnt = new  ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		
		return resEnt;
	}

	
}






