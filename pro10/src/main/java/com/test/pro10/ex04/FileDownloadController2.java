package com.test.pro10.ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController2 {

	// 파일 저장 경로
	private static String IMAGE_REPO="C:\\Users\\dbxow\\image";
	
	@RequestMapping("/test04/download.do")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		OutputStream out = response.getOutputStream();
		
		String downFile = IMAGE_REPO+ "\\" + imageFileName;
		File file = new File(downFile);
		
		// 썸네일 파일 이름 짓기
		// 원본 파일 확장자 빼고 이름만 뽑아서 thumbnail 폴더에 png로 저장 예정
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0, lastIndex);
		File thumbnail = new File(IMAGE_REPO + "\\" + "thumbnail" + "\\" + fileName + ".png");
		
		if(file.exists()) {
			// 썸네일 폴더 없으면 생성
			thumbnail.getParentFile().mkdirs();
			
			// Thumbnails.of() 는 썸네일 라이브러리 (Thumbnailator 라이브러리)
			// 1. 이미지 리사이징
			// 2. 포맷 변환
			// 3. 저장까지 한 번에 처리해주는 기능
			
			Thumbnails.of(file)					// 원본 파일 기반
						.size(50, 50)			// 50x50 크기로 저장
						.outputFormat("png")	// png로 저장
						.toFile(thumbnail);		// thumbnail 파일로 저장
		}
		
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int cnt = in.read(buffer);
			if (cnt == -1) {
				break;
			}
			out.write(buffer, 0, cnt);
			
		}
		
		in.close();
		out.close();
	}
}
