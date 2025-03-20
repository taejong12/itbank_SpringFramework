<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<th>아이디</th>
			<th>암호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<tr align="center">
			<td><input type="text" name="id" value="${member.id }" readonly></td>
			<td><input type="text" name="pwd" value="${member.pwd }"></td>
			<td><input type="text" name="name" value="${member.name }"></td>
			<td><input type="text" name="email" value="${member.email }"></td>
			<td><input type="text" name="joinDate" value="${member.joinDate }" readonly></td>
		</tr>
		<tr align="center">
			<td colspan="5">
				<button onclick="modifyForm()">회원수정폼</button>
				<button onclick="delForm()">회원삭제폼</button>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function modifyForm(){
			window.location.href="/pro06/member/modifyForm.do";
		}
		
		function delForm(){
			window.location.href="/pro06/member/delForm.do";
		}
	</script>
</body>
</html>




