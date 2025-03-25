<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<h3>업로드가 완료되었습니다.</h3>
	<h3>파일 업로드 하기</h3>
	<label>아이디:</label>
		<input type="text" value="${map.id}" readonly>
	<label>이름:</label>
		<input type="text" value="${map.name}" readonly>
	<div>
		<c:forEach var="imageFileName" items="${map.fileList}">
			<!-- 
				1. 경로에 대한 이해
				2. 웹 브라우저가 요청하는 주소는 프로젝트 Context Path부터 시작함
				3. http://localhost:8080/pro10/test03/download.do?imageFileName=파일이름.jpg(확장자 .png 등)
					http://localhost:8080: 서버 주소
					pro10: 프로젝트 이름이자 Context Path
					/test03/download.do: 실제 매핑된 컨트롤러 주소
					?imageFileName=파일이름.jpg: 파라미터로 파일명 전달
				4. JSP는 웹 브라우저가 렌더링할 HTML을 만듦
				5. <img src=""> 는 브라우저가 서버에 요청할 전체 URL의 일부이기 때문
				6. src="/test03/download.do" 로 쓰면 context path가 빠지기 때문에 404 오류가 발생
				7. 웹 애플리케이션이 pro10 이라는 이름으로 배포(deploy)되어 있기 때문
				8. pro10 이 폴더가 프로젝트 root
				9. 이 경우 URL 접근은 무조건 pro10부터 시작해야 함
				10. 프로젝트명이 바뀌는 경우도 있으므로 JSTL을 사용해서 ${pageContext.request.contextPath} 명령어 -> pro10 수정도 가능
				
				@RequestMapping("/test03/download.do") 과 src="/pro10/test03/download.do?imageFileName=${imageFileName}" URL이 매칭됨
				imageFileName 은 requestParm 으로 받아주고 있음
				
				<img src=""> 자체가 서버로 HTTP 요청 보내는 구조라서 바로 불러옴
			 -->
			<img src="/pro10/test03/download.do?imageFileName=${imageFileName}"><br><br>
			<a href="/pro10/test03/download.do?imageFileName=${imageFileName}">이미지 다운로드</a><br><br>
		</c:forEach>
	</div>
	<a href="/pro10/test03/form.do">다시 업로드 하기</a>
</body>
</html>