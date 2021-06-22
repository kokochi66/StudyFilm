<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Item</title>
</head>
<body>
	<h2>LIST</h2>
	<a href="register">상품 등록</a>
	<table border="1">
		<tr>
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">편집</th>
			<th align="center" width="80">제거</th>
		</tr>
		<c:forEach items="${itemList}" var="item">
			<tr>
				<td align="center">${item.itemId}</td>
				<td align="left">${item.itemName}</td>
				<td align="right">${item.price} 원</td>
				<td align="center"><a href="modify?itemId=${item.itemId}">상품 편집</a></td>
				<td align="center"><a href="remove?itemId=${item.itemId}">상품 제거</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
