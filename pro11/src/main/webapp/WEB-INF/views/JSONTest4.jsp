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
			let article = {
					articleNo:"123",
					writer:"김유신",
					title:"김유신입니다.",
					content:"김유신이 작성한 글 입니다."
			};
			$.ajax({
				type:'post',
				url:'/pro11/boards',
				contentType:'application/json',
				data:JSON.stringify(article),
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
			value="회원정보저장"><br><br>
	<div id="output"></div>
</body>
</html>