<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
// $(function(){ ... }) -> jQuery의 document.read() 와 같은 역할
// HTML 문서가 로드되면 실행되는 코드
	$(function(){
		$("#checkJson").click(function(){
			let member = 
					{id:'park',
					pwd:'1234',
					name:'박지성',
					email:'park@test.com'}
			$.ajax({
				type:'post',
				// Spring 서버의 해당 엔드포인트에 요청을 보냄
				url:'/pro11/test/info',
				// 요청 본문이 JSON 형식임을 명시
				contentType:'application/json',
				// JSON 문자열로 변환해서 전송
				data:JSON.stringify(member),
				// 요청이 성공하면 실행
				success:function (data, textStatus){
					
				},
				// 요청이 실패하면 실행
				error:function (data, textStatus){
					alert('에러가 발생했습니다.');
				},
				// 요청이 성공하든 실패하든 무조건 실행됨 
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
