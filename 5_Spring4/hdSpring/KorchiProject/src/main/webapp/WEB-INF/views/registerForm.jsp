<%@ page contentType="text/html; charset=UTF-8" %> <!-- JSP가 생성할 문서의 MIME타입과 문자코드를 지정한다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Register Form
</h1>

	<a href="/member/register?userId=kochi&password=1234&coin=5">register/user=kochi,pas=1234,coin=5</a>
	<a href="/member/register/abcde">register/abcde</a>
	
	<form:form modelAttribute="member" method="post" action="/member/register">
		<form:input path="userName"  /><font color="red"><form:errors path="userName"/></font> <br>
		<form:password path="password"/><font color="red"><form:errors path="password"/></font> <br>
		<form:input path="coin"/><font color="red"><form:errors path="coin"/></font> <br>
		<form:input path="birthday"/><font color="red"><form:errors path="birthday"/></font> <br>
		<input type="submit" name="btnSubmit" value="등록">
	</form:form>
	
	<form action="/member/register0202" method="post">
		<input type="text" value="korchi" name="userId">
		<input type="text" value="1234" name="password">
		<input type="submit" value="register0202">	
	</form>
	
	<form action="/member/register04" method="post">
		<input type="text" value="korchi" name="userId">
		<input type="text" value="1234" name="password">
		<input type="text" value="500" name="coin">
		<input type="submit" value="register04">	
	</form>
	
	<form action="/member/register0501" method="post">
		<input type="text" value="2021-06-20" name="dateofBirth">
		<input type="submit" value="register0501">	
	</form>
	
	<form action="/member/register0502" method="post">
	<input type="text" value="korchi" name="userId">
		<input type="text" value="1234" name="password">
		<input type="text" value="500" name="coin">
		<input type="text" value="20220620" name="birthday">
		<input type="submit" value="register0502">	
	</form>
	
	<form action="/member/register07" method="post">
		<input type="text" value="korchi" name="id">
		<input type="text" value="1234" name="pwd">
		<br>
		male <input type="radio" value="male" name="radio">
		female <input type="radio" value="female" name="radio">
		none <input type="radio" value="none" name="radio">
		<br>
		<select name="select">
			<option value="korea">대한민국</option>
			<option value="japan">일본</option>
			<option value="china">중국</option>
		</select>
		<br>
		<select name="mSelect" multiple>
			<option value="DRX">DRX</option>
			<option value="Hanhwa">한화</option>
			<option value="Sandbox">샌드박스</option>
		</select>
		<br>
		<select name="mSelect2" multiple>
			<option value="SKT">SKT</option>
			<option value="KT">KT</option>
			<option value="nongShim">농심</option>
		</select>
		<br>
		<select name="mSelect3" multiple>
			<option value="naira">나이라</option>
			<option value="hangang">한강</option>
			<option value="gang">갱</option>
		</select>
		<br>
		have <input type="checkbox" name="check" value="have">	
		what <input type="checkbox" name="check" value="what">	
		goodtime <input type="checkbox" name="check" value="goodtime">
		<br>
		SuperBee <input type="checkbox" name="check2" value="SuperBee">	
		Changmo <input type="checkbox" name="check2" value="Changmo">	
		Coogie <input type="checkbox" name="check2" value="Coogie">	
		<br>
		<input type="submit" value="register07">	
	</form>
	
		<form action="/member/register08" method="post" enctype="multipart/form-data">
		<input type="file" name="picture"> <input type="submit" value="register08">
	</form>
	
</body>
</html>
