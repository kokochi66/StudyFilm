<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>User</title>
</head>

<script src="/resources/js/jQuery-2.1.4.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#member");

		$("#btnModify").on("click", function() {
			formObj.attr("action", "/user/modify");
			formObj.attr("method", "post");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/user/list";
		});

	});
</script>

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
				<td>auth - 1</td>
				<td>
					<form:select path="authList[0].auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
					  <form:option value="ROLE_USER" label="사용자" />
					  <form:option value="ROLE_MEMBER" label="회원" />
					  <form:option value="ROLE_ADMIN" label="관리자" />
					</form:select>
				</td>
				<td><font color="red"><form:errors path="authList[0].auth" /></font></td>
			</tr>
			
			<tr>
				<td>auth - 2</td>
				<td>
					<form:select path="authList[1].auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
					  <form:option value="ROLE_USER" label="사용자" />
					  <form:option value="ROLE_MEMBER" label="회원" />
					  <form:option value="ROLE_ADMIN" label="관리자" />
					</form:select>
				</td>
				<td><font color="red"><form:errors path="authList[1].auth" /></font></td>
			</tr>
			
			<tr>
				<td>auth - 3</td>
				<td>
					<form:select path="authList[2].auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
					  <form:option value="ROLE_USER" label="사용자" />
					  <form:option value="ROLE_MEMBER" label="회원" />
					  <form:option value="ROLE_ADMIN" label="관리자" />
					</form:select>
				</td>
				<td><font color="red"><form:errors path="authList[2].auth" /></font></td>
			</tr>					
			
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
