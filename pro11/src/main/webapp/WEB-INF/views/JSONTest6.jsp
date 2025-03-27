<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test2</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			$.ajax({
				type:'delete',
				url:'/pro11/boards/123',
				contentType:'application/json',
				success:function (data, textStatus){
					alert(data);
				},
				error:function (data, textStatus){
					alert('에러가 발생했습니다.');
				},
				complete:function(data, textStatus){
					console.log('완료')
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson"
			value="회원삭제"><br><br>
	<div id="output"></div>
</body>
</html>