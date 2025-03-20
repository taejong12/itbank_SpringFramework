<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보삭제</title>
</head>
<body>
<form method="post" action="/pro06/member/del.do">
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td>아이디</td>
			<td>암호</td>
		</tr>
		<tr align = "center">
			<td><input type="text" name="id"></td>
			<td><input type="password" name="pwd"></td>	
		</tr>
		<tr align="center">
			<td colspan="4">
				<input type="submit" value="회원삭제">
				<input type="reset" value="다시입력">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>