<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ page session="false" %>
<html>
<head>
	<title>BOARD</title>
</head>
<body>

	<h3>FORM HOME</h3>
	
	<form action="/board/register">
		<input type="submit" value="register (GET)">
	</form>
	<form action="/board/register" method="post">
		<input type="submit" value="register (POST)">
	</form>
	<form action="/board/modify" method="get">
		<input type="submit" value="register (GET)">
	</form>
	<form action="/board/modify" method="post">
		<input type="submit" value="modify (POST)">
	</form>
	<form action="/board/list" method="get">
		<input type="submit" value="list (GET)">
	</form>

</body>
</html>
