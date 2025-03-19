<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<form method="post" action="/pro05/test/memberInfo.do">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>암호</td>
				<td>이름</td>
				<td>이메일</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="id"></td>
				<td><input type="password" name="pwd"></td>
				<td><input type="text" name="name"></td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="로그인">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>