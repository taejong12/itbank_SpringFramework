<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>    
<c:set var="contextPath" value="#{pageContext.request.contextPath }" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function readURL(input) {
		if(input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}
	
	let cnt = 1;
	function fn_addFile(){
		$("#d_file").append("<br><input type='file' name='file"+cnt+"'>");
		cnt++;
	}
</script>
<body>
	<h1 style="text-align:center;">새 글쓰기</h1>
	<form name="articleForm" method='post' 
		action="${contextPath }/board/addNewArticle.do"
			encType="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td align="right">작성자</td>
				<td colspan="2" align="left">
					<input type="text" size="20" maxlength="100" name="id"
					value="${member.id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td align="right">글제목</td>
				<td colspan="2"><input type="text" size="67" maxlength="500"
				name="title"></td>
			</tr>
			<tr>
				<td align="right" valign="top">글내용</td>
				<td colspan="2"><textarea name="content" rows="10" cols="69"
				maxlength="4000"></textarea></td>
			</tr>	
			<tr>
<!-- 				<td align="right">이미지파일 첨부</td>
				<td><input type="file" name="imageFileName" onchange="readURL(this);"></td>
				<td><img id="preview" src="#" width="200" height="200"></td> -->
				<td align="right">이미지파일 첨부</td>
				<td align="left"><input type="button" value="파일추가"
					onClick="fn_addFile()"></td>
			</tr>
			<tr>
				<td colspan="3"><div id="d_file"></div></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="button" value="목록보기" onclick="backToList(this.form)">
				</td>
			</tr>		
		</table>		
	</form>
</body>
