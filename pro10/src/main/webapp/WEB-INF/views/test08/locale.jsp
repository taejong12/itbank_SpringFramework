<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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