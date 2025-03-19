<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<form method="post" action="/pro05/test/login.do">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>암호</td>
				<td>이름</td>
				<td>이메일</td>
			</tr>
			<!-- ModelAndView.addObject 저장된 값 출력 -->
			<tr align="center">
				<td>${id }</td>
				<td>${pwd }</td>
				<td>${name }</td>
				<td>${email }</td>
			</tr>
		</table>
	</form>
</body>
</html>