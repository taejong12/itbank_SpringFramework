<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색창</title>
</head>
<body>
	<form action="/pro08/test04/mem1.do">
		입력 : <input type="text" name="value">
		<select name="action">
			<option value="listMembers">전체</option>
			<option value="selectMemberById">아이디</option>
			<option value="selectMemberByPwd">암호</option>
		</select>
		<input type="submit" value="검색">
	</form>
</body>
</html>




