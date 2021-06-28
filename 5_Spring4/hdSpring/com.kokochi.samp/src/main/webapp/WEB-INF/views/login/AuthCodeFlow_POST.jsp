<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>  <c:set var="path" value="/resources"/>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/login" method="post" id="userPost">
		<input type="hidden" class="broadcaster_type" name="broadcaster_type">
		<input type="hidden" class="created_at" name="created_at">
		<input type="hidden" class="description" name="description">
		<input type="hidden" class="display_name" name="display_name">
		<input type="hidden" class="id" name="id">
		<input type="hidden" class="login" name="login">
		<input type="hidden" class="offline_image_url" name="offline_image_url">
		<input type="hidden" class="profile_image_url" name="profile_image_url">
		<input type="hidden" class="type" name="type">
		<input type="hidden" class="view_count" name="view_count">
	</form>

	<script src="${path}/assets/js/jQuery-2.1.4.min.js"></script>
	<script>
		window.onload = function() {
			let client_id = '<spring:message code="private.client_id"/>';
			let client_secret = '<spring:message code="private.client_secret"/>';
			let url = `https://id.twitch.tv/oauth2/token?client_id=\${client_id}&client_secret=\${client_secret}&code=${code}&grant_type=authorization_code&redirect_uri=http://localhost:8080/login`;
			const userPost = document.querySelector('#userPost'),
				broadcaster_type = document.querySelector('.broadcaster_type')
				created_at = document.querySelector('.created_at')
				description = document.querySelector('.description')
				display_name = document.querySelector('.display_name')
				id = document.querySelector('.id')
				login = document.querySelector('.login')
				offline_image_url = document.querySelector('.offline_image_url')
				profile_image_url = document.querySelector('.profile_image_url')
				type = document.querySelector('.type')
				view_count = document.querySelector('.view_count')
			
			
			getTokens(url)
			
			function getTokens(url) {
				$.ajax({
					url : url,
					type : "POST",
					dataType : "json",
					error : function(error) {
						console.log("error 발생", error)
					}, 
					success : function(data) {
						let Userurl = `https://api.twitch.tv/helix/users`;
						getUsers(Userurl, data.access_token)
						
						
					}
				});
			}
			
			function getUsers(url, token) {
				$.ajax({
					url : url,
					type : "GET",
					headers: {
						"Authorization":"Bearer "+token,
						"Client-Id":client_id
					},
					success : function(data) {
						setUser(data['data']['0'])
					},
					error : function(error) {
						console.log("error 발생", error)
					}
				})
			}
			
			function setUser(data) {
				console.log(data)
				broadcaster_type.value = data.broadcaster_type
				created_at.value = data.created_at ? data.created_at : 2021/06/28
				description.value = data.description
				display_name.value = data.display_name
				id.value = data.id
				login.value = data.login
				offline_image_url.value = data.offline_image_url
				profile_image_url.value = data.profile_image_url
				type.value = data.type
				view_count.value = data.view_count ? data.view_count : 0
				userPost.submit()
			}
			
		}
	</script>
</body>
</html>