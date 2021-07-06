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
			<spring:message code="user.title" />
		</h2>
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
            <div class="divider-custom-line"></div>
        </div>
        
        <!-- Portfolio Grid Items-->
        <form:form modelAttribute="member" id="registForm">
        	<form:hidden path="userNo"/>
        	
        	<spring:message code="user.userId"/>
        	<form:input path="userId" cssClass="form-control" readonly="true" />
        	
        	<spring:message code="user.userName"/>
        	<form:input path="userName" cssClass="form-control" readonly="true" />
        	
        	<spring:message code="user.job"/>
        	<form:select path="job" cssClass="form-select" items="${jobList}" itemValue="value" itemLabel="label" disabled="true" />
        	
        	<spring:message code="user.auth"/>-1
        	<form:select path="authList[0].auth" cssClass="form-select" disabled="true">
        		<form:option value="" label="===선택해주세요===" />
        		<form:option value="ROLE_USER" label="사용자" />
        		<form:option value="ROLE_MEMBER" label="회원" />
        		<form:option value="ROLE_ADMIN" label="관리자" />
        	</form:select>
        	
        	<spring:message code="user.auth"/>-2
        	<form:select path="authList[1].auth" cssClass="form-select" disabled="true">
        		<form:option value="" label="===선택해주세요===" />
        		<form:option value="ROLE_USER" label="사용자" />
        		<form:option value="ROLE_MEMBER" label="회원" />
        		<form:option value="ROLE_ADMIN" label="관리자" />
        	</form:select>
        	
        	<spring:message code="user.auth"/>-3
        	<form:select path="authList[2].auth" cssClass="form-select" disabled="true">
        		<form:option value="" label="===선택해주세요===" />
        		<form:option value="ROLE_USER" label="사용자" />
        		<form:option value="ROLE_MEMBER" label="회원" />
        		<form:option value="ROLE_ADMIN" label="관리자" />
        	</form:select>
        </form:form>
        
        
        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
		  <button type="button" class="btn btn-danger" id="btnModify">modify</button>
		  <button type="button" class="btn btn-warning" id="btnList">List</button>
		</div>
    </div>
</section>

<script>
	const btnList = document.querySelector("#btnList"),
			btnModify = document.querySelector("#btnModify"),
			registForm = document.querySelector('#registForm'),
			userNo = document.querySelector('#userNo')
	
	btnList.addEventListener("click",() => {
		self.location='list'
	})
	btnModify.addEventListener('click', () => {
		self.location='modify?userNo='+ userNo.value
	})
</script>