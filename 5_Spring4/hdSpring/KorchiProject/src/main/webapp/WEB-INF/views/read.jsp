<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ page session="false" %>
<html>
<head>
	<title>BOARD</title>
</head>
<body>

	<h3>READ</h3>
	<form action="/board/get" method="get">
		<button type="submit" name="modify">MODIFY</button>
		<button type="submit" name="remove">REMOVE</button>
	</form>
	
	<a href="/board/get?list">LIST</a>
</body>
</html>
