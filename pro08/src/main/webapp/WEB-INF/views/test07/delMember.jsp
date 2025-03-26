<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" 
		action="/pro08/test07/delMember.do">
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<th>아이디</th>
		</tr>
		<tr align="center">
			<td><input type="text" name="id"></td>
		</tr>
		<tr align="center">
			<td>
			<input type="submit" value="회원삭제">	
			</td>
		</tr>
	</table>
	</form>
</body>
</html>