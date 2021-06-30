<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> <c:set var="path" value="/resources" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="style" />
</head>
<body id="page-top">
	<tiles:insertAttribute name="navbar" />
	<tiles:insertAttribute name="header" />
	
	<tiles:insertAttribute name="content" />
	
	<tiles:insertAttribute name="footer" />
	<tiles:insertAttribute name="copyright" />
	<tiles:insertAttribute name="script" />
</body>	
</html>
