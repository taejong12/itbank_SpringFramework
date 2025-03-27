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
				type:'get',
				url:'/pro11/boards/all',
				contentType:'application/json',
				success:function (data, textStatus){
					let table = "<table border='1'><tr><th>글번호</th><th>작성자</th><th>제목</th><th>내용</th></tr>";
						
					for(let i=0;i<data.length;i++){
						table += "<tr><td>"+data[i].articleNo+"</td><td>"+data[i].writer+"</td><td>"+data[i].title+"</td><td>"+data[i].content+"</td></tr>"
					}
					table += "</table>";
					$("#output").append(table);
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
			value="회원정보보기"><br><br>
	<div id="output"></div>
</body>
</html>