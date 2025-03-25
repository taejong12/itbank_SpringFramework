<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금요청</title>
</head>
<body>
	<form method="post" action="receive.do">
		<table border="1" align="center">
			<tr align="center">
				<th>계좌번호</th>
				<th>입금금액</th>
			</tr>
			<tr align="center">
				<td><input type="text" name="accNo"></td>
				<td><input type="text" name="balance"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="입금하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>