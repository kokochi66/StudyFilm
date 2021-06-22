<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>BOARD MODIFY</title>
</head>
<body>
<h1>게시판 글 수정</h1>

<form action="/board2/modify" method="post">
	
	Title : <input type="text" name="title" value="${board.title}"> <br>
	Content : <textarea name="content" >${board.content}</textarea> <br>	
	<input type="hidden" name="boardNo" value="${board.boardNo}">
	<input type="submit" value="작성하기">
</form>

</body>
</html>

