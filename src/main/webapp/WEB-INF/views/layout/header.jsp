<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />


    <!-- Header css -->
    <link rel="stylesheet" href="/css/header/header.css">
    <!-- Header css End -->

     <!-- 아이콘 css -->
     <link rel="stylesheet" href="/fonts/header/icomoon/style.css">
     <!-- 아이콘 css end -->


        <!-- postview icon -->
        <link rel="stylesheet" href="/plugins/themify/css/themify-icons.css">
        <!-- postview icon End -->


    <!-- bootstrap core css -->
       <link rel="stylesheet" type="text/css" href="css/index/bootstrap_main.css" />
       <!-- font awesome style -->
       <link href="fonts/index/font-awesome-main.min.css" rel="stylesheet" />
       <!-- Custom styles for this template -->
       <link href="css/index/style.css" rel="stylesheet" />
       <!-- responsive style -->
       <link href="css/index/responsive_main.css" rel="stylesheet" />

       <!-- postview -->

        <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
         <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.js"></script>
         <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
          <link rel="stylesheet" href="/css/post/postview.css">
          <link rel="stylesheet" href="/css/post/post.css">

<script src="https://kit.fontawesome.com/0323ea36d6.js" crossorigin="anonymous"></script>
        <!-- postview end-->

        <sec:authorize access ="isAuthenticated()">
            <sec:authentication property="principal" var="principal"/>
            </sec:authorize>




    <title>yours pick!</title>
  </head>
  <body>


    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
          </div>
        </div>
        <div class="site-mobile-menu-body"></div>
      </div>


      <div class="top-bar">
        <div class="container" id="tobBar">
          <div class="row">
            <div class="col-12">
              <a href="" class=""><span class="mr-2  icon-envelope-open-o"></span> <span class="d-none d-md-inline-block">vytjdgus1234@naver.com</span></a>
              <span class="mx-md-2 d-inline-block"></span>
              <a href="#" class=""><span class="mr-2  icon-phone"></span> <span class="d-none d-md-inline-block">010 2217 4367</span></a>


              <div class="float-right">

                <a href="https://github.com/Pyogowoon" target="_blank" class=""><span class="mr-2  icon-github"></span> <span class="d-none d-md-inline-block">github</span></a>
                <span class="mx-md-2 d-inline-block"></span>
                <a href="https://pyogowoon.tistory.com/" target="_blank" class=""><span class="mr-2  icon-tumblr"></span> <span class="d-none d-md-inline-block">tistory</span></a>

              </div>

            </div>

          </div>

        </div>
      </div>

      <header class="site-navbar js-sticky-header site-navbar-target" role="banner">

        <div class="container">
          <div class="row align-items-center position-relative">


            <div class="site-logo">
              <a href="/" class="text-black"><span class="text-primary"><img src="/images/logo.png">Pick yours!</a>
            </div>


            <div class="col-12">
              <nav class="site-navigation text-right ml-auto " role="navigation">

                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li><a href="/" class="nav-link">Home</a></li>
                  <li><a href="/user/board" class="nav-link">유저마당</a></li>


                  <li class="has">
                    <a href="/post" class="nav-link">게시글</a>

                  </li>

                <c:choose>
                <c:when test="${principal.user.id != null}">
            <li><a href="/logout" class="nav-link">LOGOUT</a></li>
                </c:when>
                <c:otherwise>
                 <li><a href="/auth/signin" class="nav-link">LOGIN</a></li>
                </c:otherwise>
                </c:choose>

                </ul>
              </nav>

            </div>

            <div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

          </div>
        </div>

      </header>

   <!-- <div class="hero" style="background-image: url('images/hero_1.jpg');"></div> -->



    <script src="/js/header/jquery-3.3.1.min.js"></script>
    <script src="/js/header/popper.min.js"></script>
    <script src="/js/header/bootstrap.min.js"></script>
    <script src="/js/header/jquery.sticky.js"></script>
    <script src="/js/header/header.js"></script>
  </body>
</html>