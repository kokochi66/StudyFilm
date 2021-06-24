<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<h1>
	Login
</h1>
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2>
<form method="post" action="/login">
	<div>
		<input type="text" name="username" value="admin">
	</div>
	<div>
		<input type="password" name="password" value="admin">
	</div>
	<div>
		<input type="submit">
	</div>
	<sec:csrfInput/>
</form>
</body>
</html>
