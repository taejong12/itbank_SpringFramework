<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
<c:choose>
	<c:when test='${param.result == "loginFailed"}'>
		<script>
			alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요.');
		</script>
	</c:when>
	<c:when test="${param.result == 'logout' }">
		<script>
			alert('로그아웃 되었습니다. 다시 로그인 하세요.');
		</script>
	</c:when>
	<c:when test="${param.result == 'notLogin' }">
		<script>
			alert('로그인이 되어 있지 않습니다. 로그인 하세요.');
		</script>
	</c:when>
</c:choose>
<script></script>
</head>
<body>
	<form method="post" action="/pro12/member/login.do">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>비밀번호</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="id" size="20"></td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>