<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pick yours! 유저마당 입니다.</title>

	<!-- 제이쿼리 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Style -->
	<link rel="stylesheet" href="/css/userheader/header.css">
	<link rel="stylesheet" href="/css/user/board.css">
	<link rel="stylesheet" href="/css/user/profile.css">
	<link rel="stylesheet" href="/css/user/upload.css">
	<link rel="stylesheet" href="/css/user/popular.css">
	<link rel="stylesheet" href="/css/user/update.css">
    <!-- Style End -->

<link rel="shortcut icon" href="/images/insta.svg">

	<!-- Fontawesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<!-- Fonts -->
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
</head>

<body>


<!-- Spring Security taglib -->

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access ="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
    </sec:authorize>

<!-- Spring Security taglib 끝 -->

<!-- principalId 담아두는 곳 -->
   <input type="hidden" id="principalId" value="${principal.user.id}"/>
   <input type="hidden" id="principalRole" value="${principal.user.role}"/>

<!-- principalId 담아두는 곳 end -->




	<header class="header">
		<div class="container">
			<a href="/" class="logo">
				<img src="/images/board_logo2.png" style="height: 76px;width:160px">
			</a>
			<nav class="navi">
				<ul class="navi-list">
					<li class="navi-item"><a href="/user/board/">
							<i class="fas fa-home"></i>
						</a></li>
					<li class="navi-item"><a href="/image/popular">
							<i class="far fa-compass"></i>
						</a></li>
					<li class="navi-item"><a href="/user/${principal.user.id}">
							<i class="far fa-user"></i>
						</a></li>
				</ul>
			</nav>
		</div>
	</header>


