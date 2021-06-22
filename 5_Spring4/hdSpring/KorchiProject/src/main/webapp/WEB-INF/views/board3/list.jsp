<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<style>
	.number {color:blue;}
	.title {color:green;}
	.writer {color:maroon;}
	.regDate {color:purple;}
</style>
<head>
	<title>BOARD LIST</title>
</head>
<body>
<h1>게시판 리스트</h1>

<ul>
	<li> <span class="number">번호</span>  <span class="title">제목</span> <span class="writer">작성자</span>  <span class="regDate">날짜</span></li>
	<c:forEach items="${list}" var="board">
		<li> <span class="number">${board.boardNo}</span> - <a class="title" href="/board2/read?boardNo=${board.boardNo}">${board.title}</a> - 
		<span class="writer">${board.writer}</span> - <span class="regDate"><fmt:formatDate pattern="yyyy-MM-dd HH;mm" value="${board.regDate}"/></span></li>
	</c:forEach>
</ul>
<input type="submit" id="register" value="글쓰기">

<script>
	window.onload = function() {
		
		var registBtn = document.querySelector('#register');
		registBtn.addEventListener('click', () => {
			self.location = "/board2/register";
		})
	}
</script>

</body>
</html>

