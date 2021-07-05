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
			<spring:message code="codedetail.list.title" />
		</h2>
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
            <div class="divider-custom-line"></div>
        </div>
        <!-- Portfolio Grid Items-->
        <form:form modelAttribute="codeDetail" action="remove" id="registForm">
        	<spring:message code="codedetail.list.classCode" />
        	<form:select path="classCode" items="${classCodeList}" itemValue="value" itemLabel="label" readonly="true" />
        	<font color="red"><form:errors path="classCode" /></font><br>
        	<spring:message code="codedetail.list.codeValue" />
        	<form:input path="codeValue" readonly="true"/>
        	<font color="red"><form:errors path="codeValue" /></font><br>
        	<spring:message code="codedetail.list.codeName" />
        	<form:input path="codeName" readonly="true"/>
        	<font color="red"><form:errors path="codeName" /></font><br>
        </form:form>
        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
		  <button type="button" class="btn btn-success" id="btnModify">modify</button>
		  <button type="button" class="btn btn-danger" id="btnRemove">remove</button>
		  <button type="button" class="btn btn-warning" id="btnList">List</button>
		</div>
    </div>
</section>

<script>
	const btnList = document.querySelector("#btnList"),
			btnRemove = document.querySelector("#btnRemove"),
			btnModify = document.querySelector("#btnModify"),
			registForm = document.querySelector('#registForm'),
			classCode = document.querySelector('#classCode'),
			codeValue = document.querySelector('#codeValue')
	
	btnList.addEventListener("click",() => {
		self.location='list'
	})
	btnRemove.addEventListener('click', () => {
		registForm.submit();
	})
	btnModify.addEventListener('click', () => {
		self.location='modify?classCode='+classCode.value+"&codeValue="+codeValue.value;
	})
</script>