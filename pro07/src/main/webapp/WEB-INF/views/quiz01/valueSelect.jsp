<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음료 선택창</title>
</head>
<body>
	<form action="/pro07/quiz01/result.do">
		<select name="drink">
			<option value="콜라">콜라</option>
			<option value="커피">커피</option>
			<option value="코코아">코코아</option>
			<option value="우유">우유</option>
		</select>
		<input type="submit" value="음료요청">
	</form>
</body>
</html>