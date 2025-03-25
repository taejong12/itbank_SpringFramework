<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	var cnt = 1;
	function fn_addFile(){
		$("#d_file").append("<br><input type='file' name='file"+cnt+"'/>");
		cnt++;
	}		
</script>
</head>
<body>
	<h3>파일 업로드 하기(썸네일 저장하기(원본 X))</h3>
	<form method="post" action="/pro10/test05/upload.do" enctype="multipart/form-data">
		<label>아이디: </label>
			<input type="text" name="id"><br>
		<label>이름: </label>
			<input type="text" name="name"><br>
		<input type="button" value="파일추가" onclick="fn_addFile()"><br>
		<div id="d_file"></div>
		<input type="submit" value="업로드"><br>
	</form>
</body>
</html>