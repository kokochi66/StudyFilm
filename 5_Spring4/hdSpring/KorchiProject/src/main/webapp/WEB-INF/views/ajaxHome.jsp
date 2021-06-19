<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ page session="false" %>
<html>
<head>
	<title>BOARD</title>
</head>
<body>
	<script src="/resources/js/jQuery-2.1.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#putBtn").on("click", function() {
				var boardNo = $("#boardNo")
				var title = $("#title")
				var content = $("#content")
				var writer = $("#writer")
				
				var boardNoVal = boardNo.val()
				var titleVal = title.val()
				var contentVal = content.val()
				var writerVal = writer.val()
				
				var boardObject = {
					boardNo: boardNoVal,
					title: titleVal,
					content: contentVal,
					writer: writerVal
				}
				
				$.ajax({
					type:"put",
					url: "/board/" + boardNoVal,
					data: JSON.stringify(boardObject),
					contentType:"application/json;charset=utf-8",
					success:function(result) {
						console.log("result:"+result);
						if(result === "SUCCESS") {
							alert("SUCCESS")
						}
					}
				})
			})
			$("#putHeaderBtn").on("click", function() {
				var boardNo = $("#boardNo")
				var title = $("#title")
				var content = $("#content")
				var writer = $("#writer")
				
				var boardNoVal = boardNo.val()
				var titleVal = title.val()
				var contentVal = content.val()
				var writerVal = writer.val()
				
				var boardObject = {
					boardNo: boardNoVal,
					title: titleVal,
					content: contentVal,
					writer: writerVal
				}
				
				$.ajax({
					type:"put",
					url: "/board/" + boardNoVal,
					headers: {
						"X-HTTP-Method-Override":"PUT"
					},
					data: JSON.stringify(boardObject),
					contentType:"application/json;charset=utf-8",
					success:function(result) {
						console.log("result:"+result);
						if(result === "SUCCESS") {
							alert("SUCCESS")
						}
					}
				})
			})
			$("#postBtn").on("click", function() {
				var boardNo = $("#boardNo")
				var title = $("#title")
				var content = $("#content")
				var writer = $("#writer")
				
				var boardNoVal = boardNo.val()
				var titleVal = title.val()
				var contentVal = content.val()
				var writerVal = writer.val()
				
				var boardObject = {
					boardNo: boardNoVal,
					title: titleVal,
					content: contentVal,
					writer: writerVal
				}
				
				$.ajax({
					type:"put",
					url: "/board/" + boardNoVal,
					data: JSON.stringify(boardObject),
					contentType:"application/json;charset=utf-8",
					success:function(result) {
						console.log("result:"+result);
						if(result === "SUCCESS") {
							alert("SUCCESS")
						}
					}
				})
			})
			$("#putJsonBtn").on("click", function() {
				var boardNo = $("#boardNo")
				var title = $("#title")
				var content = $("#content")
				var writer = $("#writer")
				
				var boardNoVal = boardNo.val()
				var titleVal = title.val()
				var contentVal = content.val()
				var writerVal = writer.val()
				
				var boardObject = {
					boardNo: boardNoVal,
					title: titleVal,
					content: contentVal,
					writer: writerVal
				}
				
				$.ajax({
					type:"put",
					url: "/board/" + boardNoVal,
					data: JSON.stringify(boardObject),
					contentType:"application/json;charset=utf-8",
					success:function(result) {
						console.log("result:"+result);
						if(result === "SUCCESS") {
							alert("SUCCESS")
						}
					}
				})
			})
			$("#putXmlBtn").on("click", function() {
				var boardNo = $("#boardNo")
				var title = $("#title")
				var content = $("#content")
				var writer = $("#writer")
				
				var boardNoVal = boardNo.val()
				var titleVal = title.val()
				var contentVal = content.val()
				var writerVal = writer.val()
				
				var boardObject = {
					boardNo: boardNoVal,
					title: titleVal,
					content: contentVal,
					writer: writerVal
				}
				
				$.ajax({
					type:"put",
					url: "/board/" + boardNoVal,
					data: JSON.stringify(boardObject),
					contentType:"application/json;charset=utf-8",
					success:function(result) {
						console.log("result:"+result);
						if(result === "SUCCESS") {
							alert("SUCCESS")
						}
					}
				})
			})
			
		})
	</script>
	
	<h1>Ajax Home</h1>
	<form>
		boardNo: <input type="text" name="boardNo" value="" id="boardNo">
		title: <input type="text" name="title" value="" id="title">
		content: <input type="text" name="content" value="" id="content">
		writer: <input type="text" name="writer" value="" id="writer">
	</form>
	
	<div>
		<button id="putBtn">MODIFY(put)</button>
		<button id="putHeaderBtn">MODIFY(put with header)</button>
		<button id="postBtn">MODIFY(post)</button>
		<button id="putJsonBtn">MODIFY(put json)</button>
		<button id="putXmlBtn">MODIFY(put Xml)</button>
	</div>
</body>
</html>
