<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--
	spring 태그 라이브러리 추가
	spring:message 태그를 사용하기 위해 필요
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
	spring:message code="key" text="기본값"  를 사용하여
	message_ko.properties, message_en.properties 등의 파일에서 번역된 텍스트를 가져옴
	test="기본값" 은 메시지 파일에서 해당 키를 찾을 수 없을 때 기본으로 표시할 텍스트
	site.title 의 값이 없다면 Member Info 출력
 -->
<title><spring:message code="site.title" text="Member Info"></spring:message></title>
</head>
<body>
	<a href="/pro10/test08/locale.do?locale=ko">한국어</a>
	<a href="/pro10/test08/locale.do?locale=en">English</a>
	<h1><spring:message code="site.title" text="Member Info"></spring:message></h1>
	<p>
		<spring:message code="site.name" text="Name"></spring:message>
		<spring:message code="name" text="Kil-Dong Hong"></spring:message>	
	</p>
	<p>
		<spring:message code="site.job" text="JOB"></spring:message>
		<spring:message code="job" text="Student"></spring:message>
	</p>
	<input type="button" value="<spring:message code='btn.send' />">
	<input type="button" value="<spring:message code='btn.cancel' />">
	<input type="button" value="<spring:message code='btn.finish' />">
</body>
</html>