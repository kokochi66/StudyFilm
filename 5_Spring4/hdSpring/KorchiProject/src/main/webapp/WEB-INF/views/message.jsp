<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>MESSAGE</title>
</head>
<body>

	<h3>message hello</h3>
	<spring:message code="welcome.message" arguments="꼬꼬치꼬치" />
</body>
</html>
