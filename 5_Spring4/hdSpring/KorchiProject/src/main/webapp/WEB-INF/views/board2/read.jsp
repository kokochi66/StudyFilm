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
	<title>BOARD READ</title>
</head>
<body>
<h1>게시판 읽기</h1>

<div> 번호 :  <span class="number">${board.boardNo}</span></div>
<div> 제목 :  <span class="title">${board.title}</span></div>
<div> 작성자 :  <span class="writer">${board.writer}</span></div>
<div> 날짜 :  <span class="regDate"><fmt:formatDate pattern="yyyy-MM-dd HH;mm" value="${board.regDate}"/></span> </div>
<div> ${board.content} </div>
<input type="submit" value="수정" id="modify">
<input type="submit" value="삭제" id="remove">
<input type="submit" value="목록" id="list">
<script>
	window.onload = function() {
		var modifyBtn = document.querySelector('#modify'),
		removeBtn = document.querySelector('#remove'),
		listBtn = document.querySelector('#list');
	
		modifyBtn.addEventListener('click', () => {
			var boardNoVal = document.querySelector('.number').innerHTML ;
			self.location = '/board2/modify?boardNo='+boardNoVal;
		})
		
		removeBtn.addEventListener('click', () => {
			var boardNoVal = document.querySelector('.number').innerHTML ;
			var CacheForm = document.createElement("form");
			CacheForm.setAttribute("method","post");
			CacheForm.setAttribute("action","/board2/remove");
			
			var CacheInput = document.createElement("input");
			CacheInput.setAttribute("type","hidden");
			CacheInput.setAttribute("name","boardNo");
			CacheInput.setAttribute("value",boardNoVal);
			
			
			CacheForm.appendChild(CacheInput);
			document.body.append(CacheForm);
			CacheForm.submit();
		})
		
		listBtn.addEventListener('click', () => {
			self.location = `/board2/list`;
		})
	}
	
</script>

</body>
</html>

