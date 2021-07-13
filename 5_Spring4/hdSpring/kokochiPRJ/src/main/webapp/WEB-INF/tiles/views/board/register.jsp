<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> <c:set var="path" value="/resources" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Portfolio cont -->
<section class="page-section portfolio" id="portfolio">
    <div class="container">
        <!-- Portfolio Section Heading-->
        <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">
			<spring:message code="board.title" />
		</h2>
		
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
            <div class="divider-custom-line"></div>
        </div>
        
        <!-- Portfolio Grid Items-->
        <form:form modelAttribute="board" action="register" id="registForm">
        	
        	<spring:message code="board.boardTitle" />
        	<form:input path="title" cssClass="form-control" /> 
        	<font color="red"><form:errors path="title" /></font><br>
        	
        	<spring:message code="board.boardWriter" />
        	<form:input path="writer" cssClass="form-control" readonly="true" /> 
        	<font color="red"><form:errors path="writer" /></font><br>
        	
        	<spring:message code="board.content" />
        	<form:textarea path="content" cssClass="form-control" /> 
        	<font color="red"><form:errors path="content" /></font><br>
        </form:form>
        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
		  <button type="button" class="btn btn-danger" id="btnRegister">Register</button>
		</div>
    </div>
</section>

<script>
	const btnList = document.querySelector("#btnList"),
			btnRegister = document.querySelector("#btnRegister"),
			registForm = document.querySelector('#registForm');
	
	btnList.addEventListener("click",() => {
		self.location='list'
	})
	btnRegister.addEventListener('click', () => {
		registForm.submit()
	})
</script>