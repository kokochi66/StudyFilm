<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>User</title>
</head>

<script src="/resources/js/jQuery-2.1.4.min.js"></script>

<body>
	<h3>LIST</h3>
	<a href="/user/register">New</a>
	
	<table border="1">
		<tr>
			<th align="center" width="60">NO</th>
			<th align="center" width="80">USERID</th>
			<th align="center" width="300">USERPW</th>
			<th align="center" width="100">USERNAME</th>
			<th align="center" width="180">REGDATE</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td align="center">${member.userNo}</td>
				<td align="center"><a href='/user/read?userNo=${member.userNo}'>${member.userId}</a></td>
				<td align="left">${member.userPw}</td>
				<td align="right">${member.userName}</td>
				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${member.regDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
