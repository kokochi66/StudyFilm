<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>BOARD REGISTER</title>
</head>
<body>
<h1>게시판 글 쓰기</h1>
<form:form action="/board2/register" method="post" modelAttribute="board">
<!-- modelAttribute를 사용할때는 객체를 직접 넘겨줘야 오류가 생기지 않는다. -->
	Title : <form:input path="title"/> <br>
	Writer : <form:input path="writer"/> <br>
	Content : <form:textarea path="content"/> <br>
	<input type="submit" value="작성하기">
</form:form>
</body>
</html>

