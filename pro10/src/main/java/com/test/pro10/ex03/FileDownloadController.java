package com.test.pro10.ex03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Spring 기반의 파일 다운로드 기능을 구현한 컨트롤러
@Controller
public class FileDownloadController {
	
	// 파일이 저장된 디렉터리(폴더) 경로
	private static String IMAGE_REPO="C:\\Users\\dbxow\\image";
	
	// "/test03/download.do?imageFileName=파일이름" 과 같은 URL로 요청하면 서버에 저장된 해당 파일을 다운로드할 수 있도록 처리하는 역할
	@RequestMapping("/test03/download.do")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 다운로드할 파일 경로 설정
		// IMAGE_REPO(기본 경로)와 imageFileName(사용자가 요청한 파일명)을 결합하여 파일의 전체 경로를 생성
		String downFile = IMAGE_REPO+ "\\" + imageFileName;
		
		// 해당 경로에 파일이 존재하는지 확인하고 파일 객체를 만듦
		File file = new File(downFile);
		
		// 브라우저가 파일을 캐시하지 않도록 설정(최신 파일을 받을 수 있도록)
		response.setHeader("Cache-Control", "no-cache");
		
		// "Content-Disposition" 을 사용하여 파일 다운로드 창을 띄우도록 설정
		// 파일을 첨부 파일로 다운로드하도록 설정
		// 브라우저가 imageFileName으로 파일을 다운로드하도록 유도함
		// attachment는 다운로드용
		// <img> 태그는 그냥 src에 걸리면 무시하고 읽음
		// 이미지니까 브라우저가 다운로드 안 하고 화면에 바로 렌더링함
		response.addHeader("Content-Disposition", "attachment;filename="+imageFileName);
		
		// 파일을 읽고 응답으로 출력 (스트림 처리)
		// 파일을 읽고 브라우저로 전송하는 과정
		
		// 1. 파일을 읽기 위한 입력 스트림 생성
		FileInputStream in = new FileInputStream(file);
		
		// 2. HTTP 응답으로 내보낼 출력 스트림 생성
		OutputStream out = response.getOutputStream();
		
		// 3. 8KB(1024*8) 크기의 버퍼를 사용하여 데이터를 전송
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			// 4. 파일에서 데이터를 버퍼 크기만큼 읽음
			int cnt = in.read(buffer);
			if (cnt == -1) {
				break;
			}
			
			// 5. 읽어온 데이터를 응답 스트림으로 클라이언트에게 전송
			out.write(buffer, 0, cnt);
		}
		
		in.close();
		out.close();
	}
}
