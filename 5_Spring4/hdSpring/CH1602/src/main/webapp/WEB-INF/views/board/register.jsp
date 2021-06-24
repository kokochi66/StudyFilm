<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Board</title>
</head>

<script src="/resources/js/jQuery-2.1.4.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#board");

		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/board/register");
			formObj.attr("method", "post");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/board/list";
		});

	});
</script>

<body>
	<h3>REGISTER</h3>
	
	<form:form modelAttribute="board" action="register">
	
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" /></td>
				<td><font color="red"><form:errors path="title" /></font></td>
			</tr>
			<tr>
				<td>Writer</td>
				<td><form:input path="writer" /></td>
				<td><font color="red"><form:errors path="writer" /></font></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><form:textarea path="content" /></td>
				<td><font color="red"><form:errors path="content" /></font></td>
			</tr>
		</table>
		
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">Register</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
