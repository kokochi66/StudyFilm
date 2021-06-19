<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ page session="false" %>
<html>
<head>
	<title>BOARD</title>
</head>
<body>

	<h3>REGISTER</h3>
	
	<form action="/board/post" method="post">
		<button type="submit" name="register">REGISTER</button>
	</form>
	
	<a href="/board/get?list">LIST</a>
</body>
</html>
