<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> <c:set var="path" value="/resources" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="row justify-content-center">
            <table class="table">
			  <thead>
			    <tr>
			      <th scope="col"><spring:message code="codedetail.list.classCode" /></th>
			      <th scope="col"><spring:message code="codedetail.list.codeValue" /></th>
			      <th scope="col"><spring:message code="codedetail.list.codeName" /></th>
			      <th scope="col"><spring:message code="codedetail.list.sortSeq" /></th>
			      <th scope="col"><spring:message code="codedetail.list.regdate" /></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${list}" var="codeDetail">
				    <tr>
				      <td>${codeDetail.classCode}</td>
				      <td>${codeDetail.codeValue}</td>
				      <td> <a href="/codedetail/read?classCode=${codeDetail.classCode}&codeValue=${codeDetail.codeValue}">${codeDetail.codeName}</a> </td>
				      <td>${codeDetail.sortSeq}</td>
				      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${codeDetail.regDate}"/> </td>
				      
				    </tr>
			  	</c:forEach>
			  </tbody>
			</table>
			<button type="button" class="btn btn-secondary col-1" id="btnRegister">Register</button>
        </div>
    </div>
</section>
<script>
const btnRegister = document.querySelector('#btnRegister')

btnRegister.addEventListener('click', () => {
	self.location = "register"
})
</script>

