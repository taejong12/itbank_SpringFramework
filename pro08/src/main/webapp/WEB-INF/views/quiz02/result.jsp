<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty name }">
		<h1>이름 : ${name }</h1>
	</c:if>
	<c:if test="${result >= 1 }">
		<h1>로그인 성공</h1>
	</c:if>
	<c:if test="${result == 0 }">
		<h1>로그인 실패</h1>
	</c:if>
</body>
</html>