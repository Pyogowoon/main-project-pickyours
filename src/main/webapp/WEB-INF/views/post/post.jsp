<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

 <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Pick yours! 게시글에 온것을 환영합니다.</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />

    </head>
    <body>

    <header>

  <%@include file="../layout/header.jsp" %>


    </header>

    <!-- search overlay -->

    <div class="input-group">

      <div class="form-outline">
       <form action="/post/search/title" method="get" name="search" id="searchForm">
        <input type="search" id="form1" name="keyword" class="form-control" placeholder="제목을 입력해주세요." />
      <button class="btn btn-primary" style="height:35px;">
              <i class="fas fa-search"></i>
                </button>
                </form>
      </div>




      </div>


    <!-- search overlay End -->


 <c:if test="${principal.user.role eq 'ADMIN' || principal.user.role eq 'SUPERADMIN'}">
        <a class="btn btn-primary" id="admin" href="/post/postsave" >어드민용 글쓰기</a>
        </c:if>
        <!-- Page content-->
        <div class="container">

            <div class="row">
                <!-- Blog entries-->


            <!--col 8 -->

            <!-- forEach 문 시작 -->

            <c:forEach var="post" items="${post.content}" begin="0" end="0">
                <div class="col-lg-8" id="bigColumn">
                    <!-- Featured blog post-->

                    <!-- card -->
                    <div class="card mb-4" id="largeColumn">

                        <a href="/post/postview/${post.id}">
                        <img class="card-img-top" src="/upload/${post.postImageUrlLeft}"
                         style="height: 600px;width:425px;margin:10px;"  alt="..." />
                        <img class="card-img-top" src="/upload/${post.postImageUrlRight}"
                         style="height: 600px;width:425px;margin:10px;"  alt="..." />
                         </a>

                        <div class="card-body">
                            <div class="small text-muted"> ${post.createDate} </div>
                            <h2 class="card-title" id="hangle"> ${post.title} </h2>
                            <h4 class="card-text" id="hangle">  ${post.content}</h4>
                            <a class="btn btn-primary" href="/post/postview/${post.id}">Read more →</a>
                        </div>
                    </div>
                     <!-- card End-->

                        </div>
                    <!--col 8 end -->

                    </c:forEach>
                       <!-- forEach 문 End -->


                     <!-- col 6 -->

                       <!-- forEach 문 시작 -->
                     <c:forEach var="post" items="${post.content}" begin="1">

                        <div class="col-lg-6" id="mediumColumn">

                            <!-- Blog post-->

                            <!-- card 4 -->
                            <div class="card mb-4">
                                <a href="/post/postview/${post.id}">
                                <img class="card-img-top" src="/upload/${post.postImageUrlLeft}"
                                 style="height: 500px;width:270px" alt="..." />
                                 <img class="card-img-top" src="/upload/${post.postImageUrlRight}"
                                  style="height: 500px;width:270px" alt="..." />
                                 </a>

                                <!-- card body -->
                               <div class="card-body">
                                   <div class="small text-muted"> ${post.createDate} </div>
                                   <h2 class="card-title" id="hangle"> ${post.title} </h2>
                                   <h4 class="card-text" id="hangle">  ${post.content}</h4>
                                   <a class="btn btn-primary" href="/post/postview/${post.id}">Read more →</a>
                               </div>
                                 <!-- card body -->

                            </div>
                            <!-- card 4 End-->


                     </div>
                    <!-- col 6 End -->

                    </c:forEach>
                       <!-- forEach 문 End -->


                    </div>
                    <!-- row End -->


                 <!-- 페이징 버튼 -->
                <ul class="pagination justify-content-center">


                <c:choose>
                <c:when test="${post.first}">
                 <li class="page-item disabled"><a class="page-link" href="?page=${post.number-1}">Previous</a></li>
                </c:when>


                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=0">first</a></li>
                <li class="page-item"><a class="page-link" href="?page=${post.number-1}">Previous</a></li>
                </c:otherwise>

                </c:choose>



                <c:choose>

                    <c:when test="${post.number <= post.totalPages-5}">
                    <c:forEach var="i" begin="${post.number+1}" end="${post.number+5}">
                                                <li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
                                            </c:forEach>

                    </c:when>

                    <c:when test ="${post.number == post.totalPages}">
                     <li class="page-item"><a class="page-link" href="?page=${post.totalPages}">${post.totalPages}</a></li>
                    </c:when>


                    <c:otherwise>

                 <c:forEach var="i" begin="${post.number+1}" end="${post.totalPages}" varStatus="status">
                 <c:choose>
                    <c:when test="${post.number < post.totalPages}">
                            <li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
                            </c:when>


                            <c:otherwise>


                            </c:otherwise>

                            </c:choose>
                        </c:forEach>
                        </c:otherwise>


                        </c:choose>

                <c:choose>

                <c:when test="${post.last}">
                 <li class="page-item disabled"><a class="page-link" href="?page=${post.number+1}">Next</a></li>
                </c:when>



                <c:otherwise>
                 <li class="page-item"><a class="page-link" href="?page=${post.number+1}">Next</a></li>

                <c:if test="${post.totalPages > 12 }">
                 <li class="page-item"><a class="page-link" href="?page=${post.number+6}">+5 Next </a></li>
                </c:if>
                </c:otherwise>

                </c:choose>

                <!-- 페이징 버튼 End -->


       <!-- container End -->
        </div>





<script src="/js/post/post.js"></script>
    </body>
</html>
