<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력창</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<th>아이디</th>
			<th>암호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일자</th>
		</tr>
		<c:forEach items="${membersList }" var="m">
			<tr align="center">
				<td>${m.id }</td>
				<td>${m.pwd }</td>
				<td>${m.name }</td>
				<td>${m.email }</td>
				<td>${m.joinDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>