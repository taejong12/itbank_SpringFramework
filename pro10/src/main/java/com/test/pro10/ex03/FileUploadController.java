package com.test.pro10.ex03;

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

// Spring MVC 기반의 파일 업로드 컨트롤러
@Controller
public class FileUploadController {
	
	// 파일이 저장된 디렉터리(폴더) 경로
	private static String IMAGE_REPO="C:\\Users\\dbxow\\image";
	
	@RequestMapping("/test03/form.do")
	public String form() {
		return "/test03/uploadForm";
	}
	
	@RequestMapping("/test03/upload.do")
	public ModelAndView upload(MultipartHttpServletRequest mRequest, HttpServletResponse response) throws IOException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// form에서 넘어온 모든 파라미터 이름들
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
		mav.setViewName("/test03/result");
		return mav;
	}

	private List<String> fileProcess(MultipartHttpServletRequest mRequest) throws IOException {
		
		List<String> fileList = new ArrayList<String>();
		// form에서 넘어온 모든 파라미터 이름들
		Iterator<String> fileNames = mRequest.getFileNames();
		
		// 클라이언트로부터 업로드된 파일들을 하나씩 처리
		while(fileNames.hasNext()){
			
			// input 태그의 name 값
			String fileName = fileNames.next();
			
			// 실제 업로드된 MultipartFile 객체
			MultipartFile mFile = mRequest.getFile(fileName);
			
			// 사용자가 업로드한 파일의 원래 파일명
			String originalFileName = mFile.getOriginalFilename();
			
			fileList.add(originalFileName);
			
			// 서버에 저장할 파일 경로 생성
			File file = new File(IMAGE_REPO + "\\" + fileName);
			
			// 파일 사이즈가 0이 아니면 업로드된 파일이 있다는 뜻
			if(mFile.getSize() != 0) {
				
				// 지정된 경로에 파일이 없으면
				if(!file.exists()) {
					
					// 부모 폴더가 없다면 mkdirs()로 폴더 생성
					if(file.getParentFile().mkdirs()) {
						
						// 빈 파일 생성 (사실상 아래 transferTO() 에서 덮어쓰기 됨)
						file.createNewFile();
					}
				}
				
				// 참고: file.createNewFile()는 없어도 되는 부분, transferTO()가 알아서 파일 생성해줌
				// 파일 저장 (복사)
				// 업로드된 파일을 서버 디렉토리롤 실제 저장
				mFile.transferTo(new File(IMAGE_REPO + "\\" + originalFileName));
			}
		}
		
		return fileList;
	}
}
