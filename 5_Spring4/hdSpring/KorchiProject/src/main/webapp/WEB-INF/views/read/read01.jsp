<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ page session="false" %>
<html>
<head>
	<title>BOARD</title>
</head>
<body>

	<h3>READ01 Result</h3>
	
	userId : ${member.userName} <br>
	password : ${member.password} <br>
	coin : ${member.coin} <br>
	birthday : ${member.birthday} <br>
</body>
</html>
