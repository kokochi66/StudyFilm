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

		console.log(formObj);

		$("#btnModify").on("click", function() {
			formObj.attr("action", "/user/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/user/remove");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/user/list";
		});

	});
</script>

<body>
	<h3>READ</h3>
	
	<form:form modelAttribute="member">
	
		<form:hidden path="userNo" />
		
		<table>
			<tr>
				<td>userid</td>
				<td><form:input path="userId" readonly="true" /></td>	
			</tr>
			<tr>
				<td>username</td>
				<td><form:input path="userName" readonly="true" /></td>
			</tr>
			<tr>
				<td>auth</td>
				<td>
					<form:select path="auth" disabled="true">
						<form:option value="" label="=== 선택해 주세요 ===" />
					  	<form:option value="ROLE_USER" label="사용자" />
					  	<form:option value="ROLE_MEMBER" label="회원" />
					  	<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select>
				</td>
			</tr>
		</table>
	
	</form:form>
	
	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
