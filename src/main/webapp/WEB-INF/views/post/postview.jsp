<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Yours pick!</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--Favicon-->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">

<!--

</head>



<body>

<header>
<%@ include file="../layout/header.jsp"%>

</header>

    <!--search overlay start-->
    <div class="search-wrap">
        <div class="overlay">
            <form action="#" class="search-form">
                <div class="container">
                    <div class="row">
                        <div class="col-md-10 col-9">
                            <input type="text" class="form-control" placeholder="Search..." />
                        </div>
                        <div class="col-md-2 col-3 text-right">
                            <div class="search_toggle toggle-wrap d-inline-block">
                                <i class="ti-close"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--search overlay end-->

    <section class="single-block-wrapper section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                    <div class="row">
                        <div class="col-md-12">
                            <article class="post">

                                <div class="post-header mb-5 text-center">

                                    <h2 class="post-title mt-2">
                                      title : ${post.title}
                                    </h2>

                                    <div class="post-meta">
                                        <span class="text-uppercase font-sm letter-spacing-1 mr-3">writer : ${post.user.username}</span>
                                        <span class="text-uppercase font-sm letter-spacing-1">Date : ${post.createDate}</span>
                                    </div>
                                </div>

                               <!--video post start-->
                                      <div class="post-img position-relative mb-4">
                                          <a href="#"><img class="img-fluid w-100" src="/upload/${post.postVideoUrl}" alt=""></a>
                                          <a href="https://www.youtube.com/watch?v=m2h8T1RGTag"
                                              class="play-btn popup-youtube"><i class="ti-control-play"></i></a>
                                      </div>
                                      <!--video post end-->

                                <div class="post-body">
                                    <div class="entry-content">
                                        <p> content(본문) : ${post.content}</p>
                                        <h2 class="mt-4 mb-3">entryTitle(소제목) : ${post.entryTitle}</h2>
                                        <p> entryContent(소본문) : ${post.entryContent} </p>


                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <img src="/upload/${post.postImageUrlLeft}"style="height: 300px;width:250px" alt="post-img1"
                                                    class="img-fluid mr-4 w-100">
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <img src="/upload/${post.postImageUrlRight}"style="height: 300px;width:250px" alt="post-img2"
                                                    class="img-fluid mr-4 w-100">
                                            </div>
                                        </div>

                                     <br/>
                                     <br/>
                                     <br/>


                                    </div>




                                    <div
                                        class="tags-share-box center-box d-flex text-center justify-content-between border-top border-bottom py-3">



                                        <div class="post-share">
                                            <span class="count-number-like">likes : 좋아요 2</span>
                                            <a class="penci-post-like single-like-button"><i class="ti-heart"></i></a>
                                        </div>


                                    </div>
                                </div>
                            </article>
                        </div>
                    </div>
                    <div class="post-author d-flex my-5">
                        <div class="author-img">
                            <img alt="" src="/upload/${post.user.profileImageUrl}" class="avatar avatar-100 photo" width="100"
                                height="100">
                        </div>

                        <div class="author-content pl-4">
                            <h4 class="mb-3"><a href="#" title="" rel="author" class="text-capitalize">userId : ${post.user.username}</a>
                            </h4>
                            <p>user자기소개 : ${post.user.bio} </p>


                        </div>
                    </div>


                        <!-- comment 전체 박스 -->
                    <div class="comment-area my-5" id="commentContent">





 <span class="text" style = " font-size:1.5em;" id="commentSize">${postComment.size()}</span>
<span class="text-uppercase" style = " font-size:1.5em;" >Comments</span>

<hr/>



                         <c:forEach var="list" items="${postComment}">

                         <!-- 댓글 박스 area -->


                         <!--댓글 동적 박스-->
    <span class="test" id="deleteArea-${list.id}">


            <c:choose>
            <c:when test="${principal.user.username ==  list.commentUser}">
             <span class="delete" onclick="deleteButton(${list.id})" style="cursor:pointer; cursor:hand;"> X</span>
            </c:when>
            <c:otherwise>
         <span class="delete"> </span>
            </c:otherwise>
            </c:choose>


                        <div class="comment-area-box media-${list.id}">

                            <img alt="" src="/upload/${post.user.profileImageUrl}" onerror="this.src='/images/person.jpeg'" style="height: 70px;width:90px" class="img-fluid float-left mr-3 mt-2">



                           <!-- 댓글 박스 -->
                            <div class="media-body ml-4" >
                                <h4 class="mb-0">${list.commentUser}</h4>
                                <span class="date-comm font-sm text-capitalize text-color"> <i
                                        class="ti-time mr-2"></i>${list.createDate} </span>

                            <!-- 댓글 칸 -->
                                <div class="comment-content mt-1">
                                    <p>${list.content}</p>
                                </div>
                            <!-- 댓글 칸 End-->

                            </br>

                            </div>
                            <!-- 댓글 박스 End -->


                        </div>
                          <!-- 댓글 박스 area End-->
                                 </c:forEach>


                                </span>
                                <!--댓글 동적 박스 End-->
                    </div>
                    <!-- comment 전체 박스 End -->

                 <!-- <form class="comment-form mb-5 gray-bg p-5" id="comment-form" method="post"> -->

                        <h3 class="mb-4 text-center">Leave a comment</h3>
                        <div class="row">
                            <div class="col-lg-12">
                                <textarea class="form-control mb-3" id="postContent" name="content" cols="30" rows="5"
                                    placeholder="Comment"></textarea>
                                <input type="hidden" name="profile" id="profileImage" value="${post.user.profileImageUrl}"/>
                                <input type="hidden" name="username" id="profileUsername" value="${principal.user.username}"/>
                        <input class="btn btn-primary" type="button"
                        onclick="postComment(${post.id})"
                                                value="Submit Message">
                            </div>

                        </div>



                  <!--  </form>   -->

                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="sidebar sidebar-right">
                        <div class="sidebar-wrap mt-5 mt-lg-0">
                            <div class="sidebar-widget about mb-5 text-center p-3">
                                <div class="about-author">
                                    <img src="/upload/${post.postImageUrlLeft}" alt="" class="img-fluid">
                                </div>
                                <h4 class="mb-0 mt-4">${post.actor}</h4>
                                <p>job : ${post.job} </p>
                                <p> 키 : ${post.height} </p>
                                <p> 몸무게 : ${post.weight} </p>
                                <img src="../images/liammason.png" alt="" class="img-fluid">
                            </div>

                            <div class="sidebar-widget follow mb-5 text-center">
                                <h4 class="text-center widget-title">Follow Me</h4>
                                <div class="follow-socials">
                                    <a href="#"><i class="ti-facebook"></i></a>
                                    <a href="#"><i class="ti-twitter"></i></a>
                                    <a href="#"><i class="ti-instagram"></i></a>
                                    <a href="#"><i class="ti-youtube"></i></a>
                                    <a href="#"><i class="ti-pinterest"></i></a>
                                </div>
                            </div>

                            <div class="sidebar-widget mb-5 ">
                                <h4 class="text-center widget-title">Trending Posts</h4>

                                <div class="sidebar-post-item-big">
                                    <a href="blog-single.html"><img src="../images/news/img-1.jpg" alt=""
                                            class="img-fluid"></a>
                                    <div class="mt-3 media-body">
                                        <span class="text-muted letter-spacing text-uppercase font-sm">September 10,
                                            2019</span>
                                        <h4><a href="blog-single.html"> 뭘할지 미정인데 광고를 넣을까 ?</a></h4>
                                    </div>
                                </div>

                                <div class="media border-bottom py-3 sidebar-post-item">
                                    <a href="#"><img class="mr-4" src="../images/news/thumb-1.jpg" alt=""></a>
                                    <div class="media-body">
                                        <span class="text-muted letter-spacing text-uppercase font-sm">September 10,
                                            2019</span>
                                        <h4><a href="blog-single.html">Thoughtful living in los Angeles</a></h4>
                                    </div>
                                </div>

                                <div class="media py-3 sidebar-post-item">
                                    <a href="#"><img class="mr-4" src="../images/news/thumb-2.jpg" alt=""></a>
                                    <div class="media-body">
                                        <span class="text-muted letter-spacing text-uppercase font-sm">September 10,
                                            2019</span>
                                        <h4><a href="blog-single.html">Vivamus molestie gravida turpis.</a></h4>
                                    </div>
                                </div>
                            </div>


                            <div class="sidebar-widget category mb-5">
                                <h4 class="text-center widget-title">Catgeories</h4>
                                <ul class="list-unstyled">
                                    <li class="align-items-center d-flex justify-content-between">
                                        <a href="#">Innovation</a>
                                        <span>14</span>
                                    </li>
                                    <li class="align-items-center d-flex justify-content-between">
                                        <a href="#">Software</a>
                                        <span>2</span>
                                    </li>
                                    <li class="align-items-center d-flex justify-content-between">
                                        <a href="#">Social</a>
                                        <span>10</span>
                                    </li>
                                    <li class="align-items-center d-flex justify-content-between">
                                        <a href="#">Trends</a>
                                        <span>5</span>
                                    </li>
                                </ul>
                            </div>

                            <div class="sidebar-widget subscribe mb-5">
                                <h4 class="text-center widget-title">Newsletter</h4>
                                <input type="text" class="form-control" placeholder="Email Address">
                                <a href="#" class="btn btn-primary d-block mt-3">Sign Up</a>
                            </div>

                            <div class="sidebar-widget sidebar-adv mb-5">
                                <a href="#"><img src="../images/sidebar-banner3.png" alt="" class="img-fluid w-100"></a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>




    <!-- THEME JAVASCRIPT FILES
================================================== -->


    <!-- main js -->

    <script src="/js/post/postview.js"></script>

    <!-- <script src="/js/custom.js"></script> -->


</body>

</html>