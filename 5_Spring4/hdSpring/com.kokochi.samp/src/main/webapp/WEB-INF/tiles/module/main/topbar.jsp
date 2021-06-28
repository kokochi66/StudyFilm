<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %><c:set var="path" value="/resources"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>topbar</title>
</head>
<body>
  <!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-none d-lg-block">
    <div class="container d-flex">
      <div class="contact-info mr-auto">
        <i class="icofont-envelope"></i><a href="kokochikochi@gmail.com">kokochikochi@gmail.com</a>
        <i class="icofont-phone"></i> +1 5589 55488 55
      </div>
      <div class="social-links">
        <a href="https://www.twitch.tv/" class="twitch"><i class="icofont-twitch"></i></a>
        <a href="https://id.twitch.tv/oauth2/authorize?client_id=mj1gw4x1w8nwqlui0w1nqbgegmgr3x&redirect_uri=http://localhost:8080/login&response_type=code&scope=&state=asdasdaszvx" class="login"><i class="icofont-user-alt-7"></i></a>
        <a href="#" class="alarm"><i class="icofont-alarm"></i></a>
      </div>
    </div>
  </section>
</body>

</html>