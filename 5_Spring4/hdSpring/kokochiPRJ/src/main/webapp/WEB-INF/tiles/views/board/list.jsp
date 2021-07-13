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
			<spring:message code="board.title" />
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
			      <th scope="col"><spring:message code="board.boardNo" /></th>
			      <th scope="col"><spring:message code="board.boardTitle" /></th>
			      <th scope="col"><spring:message code="board.boardWriter" /></th>
			      <th scope="col"><spring:message code="board.boardRegdate" /></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${list}" var="board">
				    <tr>
				      <td>${board.boardNo}</td>
				      <td><a href="/board/read?boardNo=${board.boardNo}">${board.title}</a></td>
				      <td>${board.writer}</td>
				      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regDate}"/> </td>
				    </tr>
			  	</c:forEach>
			  </tbody>
			</table>
			 <div class="btn-group col-2" role="group">
			 	<button type="button" class="btn btn-success" id="btnRegister">Register</button>
				<button type="button" class="btn btn-danger" id="btnSetup">Setup</button>
			 </div>

        </div>
    </div>
</section>
<script>
const btnRegister = document.querySelector('#btnRegister'),
btnSetup = document.querySelector('#btnSetup')

btnRegister.addEventListener('click', () => {
	self.location = "register"
})
btnSetup.addEventListener('click', () => {
	self.location = "setup"
})
</script>

