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
			<spring:message code="codeclass.list.title" />
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
			      <th scope="col">#</th>
			      <th scope="col"><spring:message code="codeclass.list.regdate" /></th>
			      <th scope="col"><spring:message code="codeclass.list.classCode" /></th>
			      <th scope="col"><spring:message code="codeclass.list.className" /></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${list}" var="codeClass">
				    <tr>
				      <th scope="row">1</th>
				      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${codeClass.regDate}"/> </td>
				      <td><a href="/codeclass/read?classCode=${codeClass.classCode}">${codeClass.classCode}</a></td>
				      <td>${codeClass.className}</td>
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
	location.href = "/codeclass/register"
})
</script>

