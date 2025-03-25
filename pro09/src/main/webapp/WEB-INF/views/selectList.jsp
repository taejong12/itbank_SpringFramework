<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌정보</title>
</head>
<body>
	<table border="1" align="center">
		<tr width="80%" bgcolor="lightgreen" align="center">
			<th>계좌번호</th>
			<th>계좌주 이름</th>
			<th>잔액</th>
		</tr>
		<c:forEach	items="${accList}" var="acc">
		<tr align="center">
			<td>${acc.accNo }</td>
			<td>${acc.accName }</td>
			<td>${acc.balance }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>