<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Pick yours!</title>
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

                                <c:if test="${principal.user.role eq 'ADMIN' || principal.user.role eq 'SUPERADMIN'}">

                                 <span class="delete" onclick="postDelete(${post.id})" style="cursor:pointer;" > 삭제하기</span>
                                                <span class="update"><a href="/post/postupdate/${post.id}" >수정하기</a></span>

                                                <br/>
                                </c:if>



                                    <h2 class="post-title mt-2" id="hangle">
                                      ${post.title}
                                    </h2>

                                    <div class="post-meta">
                                        <span class="text-uppercase font-sm letter-spacing-1 mr-3">writer : ${post.user.username}</span>
                                        <span class="text-uppercase font-sm letter-spacing-1">Date : ${post.createDate}</span>
                                    </div>
                                </div>

                               <!--video post start-->
                                      <div class="post-img position-relative mb-4">


        <!-- toggle시 나오는 videoContents 시작 -->
 <div class="videoContents">
	 <video id="video2"  controls preload="auto" width="640" height="268" data-setup='{}'>
	    <source src="/upload/${post.postVideoUrl}" >


      Your browser does not support the video tag.</video>

     <!-- shopInfo -->
         <div class="shopInfo">
          <img src="/upload/${post.postImageUrlRight}"style="height:600px;width:350px" alt="post-img2"
         class="img-fluid mr-4 w-100">

         <br/>


          </div>

       <!-- shopInfo End -->

    <!-- actorInfo -->
      <div class="actorInfo" style="height:600px;width:350px">
       <div class="sidebar-widget about mb-5 text-center p-3">
                                      <div class="about-authors" >
                                          <img src="/upload/${post.postImageUrlLeft}" alt="" class="img-fluid">
                                      </div>
                                      <p class="hangle">${post.actor}</p>

                                      <p class="hangle"> 키 : ${post.height} </p>
                                      <p class="hangle"> 몸무게 : ${post.weight} </p>
                                          <p> ${post.job} </p>
                                          <p> <a href="${post.entryContent}"></a>${post.entryContent} </p>

                                  </div>
      </div>

          <!-- actorInfo End-->

                    <!--닫기-->
                  <button onclick="modalClose()" style="width:30px;height:30px;">
      				<i class="fas fa-times"></i>
      			</button>
                      <!-- 닫기 End -->



<button class="toggle-1" onclick="toggle()" style="width:120px;height:70px;">
<i class="fa-solid fa-shirt fa-2x"></i>
</button>

<button class="toggle-2" onclick="actorToggle()" style="width:120px;height:70px;">
<i class="fa-sharp fa-solid fa-id-card fa-2x"></i>
</button>

                </div>
                <!-- toggle 시 나오는 videoContent End  -->
                                    <span
                                   class="play-btn popup-youtube" onclick="modalOpen()"><i class="fa-solid fa-play"></i></i></span>

                                      <video id="mainVideo"    data-setup='{}'>
                                      	    <source src="/upload/${post.postVideoUrl}" >



                                      </div>
                                      <!--video post end-->

                                <div class="post-body">
                                    <div class="entry-content">

                                       <h1 class="hangle">${post.content} </h1>

                                       <br/>
                                       <br/>
                                       <br/>

                                        <h3 class="hangle" id="brand"> ${post.entryTitle}</h2>



                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <img src="/upload/${post.postImageUrlLeft}"style="height: 600px;width:250px" alt="post-img1"
                                                    class="img-fluid mr-4 w-100">
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <img src="/upload/${post.postImageUrlRight}"style="height: 600px;width:250px" alt="post-img2"
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
                           <span class="count-number-like">likes :</span>
                           <span class="count-number-like" id="likeSize"> ${post.postLikes.size()}</span>

                           <!-- 좋아요 -->

                            <c:choose>

                        <c:when test="${postLikes.user.id == principal.user.id}">
                        <a class="penci-post-like single-like-button" id="toggle" onclick="toggleUnLike(${post.id})"><i class= "fas fa-heart active" style="color:red;" id="postUnLikeIcon-${post.id}"></i></a>
                        </c:when>


                        <c:otherwise>

 <a class="penci-post-like single-like-button" id="toggle"  onclick="toggleLike(${post.id})"><i class="fa-heart far" style="color:red;" id="postLikeIcon-${post.id}" ></i></a>

                        </c:otherwise>

                        </c:choose>
    <!-- 좋아요 끝 -->




                                    </div>
                                </div>
                            </article>
                        </div>
                    </div>
                    <div class="post-author d-flex my-5">
                        <div class="author-img">
                            <img alt="" src="/upload/${post.user.profileImageUrl}" onerror="this.src='/images/person.jpeg'" class="avatar avatar-100 photo" width="100"
                                height="100">
                        </div>

                        <div class="author-content pl-4">
                            <h4 class="mb-3"><a href="/user/${post.user.id}" title="" rel="author" class="hangle">글쓴이 : ${post.user.username}</a>
                            </h4>
                            <p class="hangle">구매 정보: </p>
                            <h4 class="hangle">${post.entryContent} </h1>


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
             <span class="delete" onclick="postCommentDelete(${list.id})" style="cursor:pointer; cursor:hand;"> X</span>
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
                                        class="fa-solid fa-clock"></i>${list.createDate} </span>

                            <!-- 댓글 칸 -->
                                <div class="comment-content mt-1">
                                    <p class="hangle">${list.content}</p>
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
                                <h4 class="mb-0 mt-4" id="hangle">${post.actor}</h4>

                                <p class="hangle"> 키 : ${post.height} </p>
                                <p class="hangle"> 몸무게 : ${post.weight} </p>
                                    <p class="hangle">instagram : ${post.job} </p>
                                <img src="../images/liammason.png" alt="" class="img-fluid">
                            </div>

                            <div class="sidebar-widget follow mb-5 text-center">
                                <h4 class="text-center widget-title">Follow Me</h4>
                                <div class="follow-socials">
                                    <a href="https://www.facebook.com" target="_blank"><i class="fa-brands fa-square-facebook"></i></a>
                                    <a href="https://twitter.com/?lang=ko" target="_blank"><i class="fa-brands fa-square-twitter"></i></a>
                                    <a href="https://www.instagram.com/" target="_blank"><i class="fa-brands fa-instagram"></i></a>
                                    <a href="https://www.youtube.com" target="_blank"><i class="fa-brands fa-youtube"></i></a>
                                    <a href="https://www.pinterest.co.kr/" target="_blank"><i class="fa-brands fa-square-pinterest"></i></a>
                                </div>
                            </div>

                            <div class="sidebar-widget mb-5 ">
                                <h4 class="text-center widget-title">Trending Posts</h4>

                            <c:forEach  var="item" items="${post.user.posts}" begin="0" end="2">

                                <div class="sidebar-post-item-big">

                                    <div class="mt-3 media-body">
                                        <span class="text-muted letter-spacing text-uppercase font-sm">${item.createDate}
                                           </span>
                                        <h4><a class="hangle" href="/post/postview/${item.id}">${item.title}</a></h4>
                                    </div>
                                     <a href="/post/postview/${item.id}"><img src="/upload/${item.postImageUrlLeft}"
                                      style="height: 150px;width:110px"alt=""
                                            class="img-fluid"></a>
                                             <a href="/post/postview/${item.id}"><img src="/upload/${item.postImageUrlRight}"
                                                                                  style="height: 150px;width:110px"alt=""
                                                                                        class="img-fluid"></a>

                                </div>

                                </c:forEach>


                            </div>




                            <div class="sidebar-widget sidebar-adv mb-5">
                                <a href="#"><img src="/images/logo.png"  alt="" class="img-fluid" style="width:280px;"></a>
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

     <-- main js -->


</body>

</html>