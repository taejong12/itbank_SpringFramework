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
	<h3>파일 업로드 하기(썸네일 바로 출력(저장 X))</h3>
	<label>아이디:</label>
		<input type="text" value="${map.id}" readonly>
	<label>이름:</label>
		<input type="text" value="${map.name}" readonly>
	<div>
		<c:forEach var="imageFileName" items="${map.fileList}">
			<img src="/pro10/test05/download.do?imageFileName=${imageFileName}"><br><br>
		</c:forEach>
	</div>
	<a href="/pro10/test05/form.do">다시 업로드 하기</a>
</body>
</html>