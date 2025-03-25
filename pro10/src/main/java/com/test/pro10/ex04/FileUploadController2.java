package com.test.pro10.ex04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController2 {
	// 파일 저장 경로
	private static String IMAGE_REPO="C:\\Users\\dbxow\\image";
	
	@RequestMapping("/test04/form.do")
	public String form() {
		return "/test04/uploadForm";
	}
	
	@RequestMapping("/test04/upload.do")
	public ModelAndView upload(MultipartHttpServletRequest mRequest, HttpServletResponse response) throws IOException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Enumeration<String> enu = mRequest.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = mRequest.getParameter(name);
			map.put(name, value);
			
		}
		
		List<String> fileList = fileProcess(mRequest);
		map.put("fileList", fileList);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("/test04/result");
		return mav;
	}

	private List<String> fileProcess(MultipartHttpServletRequest mRequest) throws IOException {
		
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = mRequest.getFileNames();
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = mRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			
			fileList.add(originalFileName);
			File file = new File(IMAGE_REPO + "\\" + fileName);
			
			if(mFile.getSize() != 0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(IMAGE_REPO + "\\" + originalFileName));
			}
		}
		
		return fileList;
	}
}
