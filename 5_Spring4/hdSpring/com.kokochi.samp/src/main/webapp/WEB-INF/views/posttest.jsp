<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<form action="/post" method="post" id="userPost">
		<input type="text" class="broadcaster_type" name="broadcaster_type" value="typeA">
		<input type="text" class="description" name="description" value="desc">
		<input type="text" class="display_name" name="display_name">
		<input type="text" class="id" name="id">
		<input type="text" class="login" name="login">
		<input type="text" class="offline_image_url" name="offline_image_url">
		<input type="text" class="profile_image_url" name="profile_image_url">
		<input type="text" class="type" name="type">
		<input type="text" class="view_count" name="view_count">
		<input type="submit" value="제출">
	</form>
	
</body>
</html>