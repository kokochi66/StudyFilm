<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> <c:set var="path" value="/resources"/>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Spring Framework Project for kokochi</title>
	<tiles:insertAttribute name="style" />
	<%-- <jsp:include page="module/style.jsp" flush="false" /> --%>
</head>

<body>

	<!-- top_bar 모듈 -->
	<%-- <jsp:include page="module/topbar.jsp" flush="false" /> --%>
	<!-- Header 모듈 -->
	<%-- <jsp:include page="module/header.jsp" flush="false" /> --%>
	

	<!-- ======= Footer ======= -->
	<%-- <jsp:include page="module/footer.jsp" flush="false" /> --%>
	
	
	<!-- 스크립트 모듈 -->
	<%-- <jsp:include page="module/script.jsp" flush="false" /> --%>
</body>

</html>