<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>User</title>
</head>

<script src="/resources/js/jQuery-2.1.4.min.js"></script>

<body>
	<h3>MODIFY</h3>
	
	<form:form modelAttribute="member" action="modify">
	
		<form:hidden path="userNo" />
		
		<table>
			<tr>
				<td>userid</td>
				<td><form:input path="userId" readonly="true" /></td>
				<td><font color="red"><form:errors path="userId" /></font></td>
			</tr>
			<tr>
				<td>username</td>
				<td><form:input path="userName" /></td>
				<td><font color="red"><form:errors path="userName" /></font></td>
			</tr>
			
			<tr>
				<td>auth</td>
				<td>
					<form:select path="auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
					  <form:option value="ROLE_USER" label="사용자" />
					  <form:option value="ROLE_MEMBER" label="회원" />
					  <form:option value="ROLE_ADMIN" label="관리자" />
					</form:select>
				</td>
				<td><font color="red"><form:errors path="auth" /></font></td>
			</tr>
			
		</table>
		
		<div>
		<input type="submit" value="Submit" />
		</div>
		
		<a href="list">List</a>
	
	</form:form>
</body>
</html>
