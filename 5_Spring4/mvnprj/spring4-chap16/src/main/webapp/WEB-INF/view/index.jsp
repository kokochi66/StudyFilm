<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>인덱스 페이지</title>
</head>
<body>
<!-- authorize태그는 현재 사용자가 특정 권한이 있으면 몸체 내용을 보여주는 기능을 한다. -->
<sec:authorize access="isAuthenticated()">
<!-- authentication 태그는 현재 접속한 사용자의 인증 정보를 보여준다. -->
<sec:authentication property="name"/>님 환영합니다.
</sec:authorize>
<ul>
	<li><a href="<c:url value='/home/main' />">/home/main</a></li>
	<li><a href="<c:url value='/member/main' />">/member/main</a></li>
	<li><a href="<c:url value='/manager/main' />">/manager/main</a></li>
	<li><a href="<c:url value='/admin/main' />">/admin/main</a></li>
	<sec:authorize access="isAuthenticated()">
	<li><a href="<c:url value='/j_spring_security_logout' />">/j_spring_security_logout</a></li>
	</sec:authorize>
</ul>
</body>
</html>
