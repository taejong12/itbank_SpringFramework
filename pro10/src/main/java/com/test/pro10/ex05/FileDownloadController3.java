package com.test.pro10.ex05;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController3 {

	// 파일 저장 경로
	private static String IMAGE_REPO="C:\\Users\\dbxow\\image";
	
	@RequestMapping("/test05/download.do")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		OutputStream out = response.getOutputStream();
		
		String downFile = IMAGE_REPO+ "\\" + imageFileName;
		File file = new File(downFile);
		
		if(file.exists()) {
			// 썸네일 만들고 바로 클라이언트로 전송
			// FileInputStream 사용 안함
			Thumbnails.of(file)
					.size(50, 50)			// 썸네일 크기 (50x50)
					.outputFormat("png")	// 출력 포맷을 PNG로 설정
					.toOutputStream(out);	// 파일로 저장하지 않고, OutputStream 으로 출력
		}
		
		out.close();
	}
}
