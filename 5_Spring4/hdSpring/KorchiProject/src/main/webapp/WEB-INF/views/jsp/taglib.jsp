<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ page session="false" %>
<html>
<head>
	<title>JSP</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h2>JSTL</h2>
	<c:forEach var="hobby" items="${hobbyArray}">
		<c:out value="${hobby}"></c:out>
	</c:forEach>
	<!-- 들어온 hobbyArray에서 값을 하나씩 반복문으로 꺼내어 출력한다. -->
	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<h2>spring-form JSP Tag Library</h2>
	<form:form>
		<form:input path="userId"/><font color="red"><form:errors path="userId"/></font>
	</form:form>
	<!-- HTML 폼용 라이브러리를 사용, 경로로 폼  요청을 보내준다. - 8장에서 자세히 -->
	
	<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
	<spring:message code="welcome.message" arguments="korchi" />
	<!-- 스프링 MVC의 범용 태그 라이브러리 및 EL 함수를 제공한다. - 10장에서 자세히 -->
	
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
	<sec:authorize access="isAnoymouse()"/>
	<!-- 스프링 시큐리티가 제공하는 인증 및 인가용 태그 라이브러리다. -  18장 스프링 시큐리티에서 자세히 -->
	
</body>
</html>
