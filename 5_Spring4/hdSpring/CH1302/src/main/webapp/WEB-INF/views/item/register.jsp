<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Item</title>
</head>

<script src="/resources/js/jQuery-2.1.4.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#item");

		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/item/register");
			formObj.attr("method", "post");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/item/list";
		});

	});
</script>

<body>
	<h2>REGISTER</h2>
	<form:form modelAttribute="item" action="register" enctype="multipart/form-data">
		<table>
			<tr>
				<td>상품명</td>
				<td><form:input path="itemName" /></td>
				<td><font color="red"><form:errors path="itemName" /></font></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><form:input path="price" />&nbsp;원
				</td>
				<td><font color="red"><form:errors path="price" /></font></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="picture" /></td>
				<td></td>
			</tr>
			<tr>
				<td>개요</td>
				<td><form:textarea path="description" />
				</td>
				<td><form:errors path="description" /></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">Register</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
