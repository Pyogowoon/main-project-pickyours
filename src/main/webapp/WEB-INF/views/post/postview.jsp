<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                      title : 아스날
                                    </h2>

                                    <div class="post-meta">
                                        <span class="text-uppercase font-sm letter-spacing-1 mr-3">writer : by 표성현</span>
                                        <span class="text-uppercase font-sm letter-spacing-1">Date : January 17,2019</span>
                                    </div>
                                </div>

                               <!--video post start-->
                                                              <div class="post-img position-relative mb-4">
                                                                  <a href="#"><img class="img-fluid w-100" src="../images/fashion/b6.jpg" alt=""></a>
                                                                  <a href="https://www.youtube.com/watch?v=m2h8T1RGTag"
                                                                      class="play-btn popup-youtube"><i class="ti-control-play"></i></a>
                                                              </div>
                                                              <!--video post end-->

                                <div class="post-body">
                                    <div class="entry-content">
                                        <p> content(본문) : 본문 텍스트.</p>
                                        <h2 class="mt-4 mb-3">entryTitle(소제목) : 완벽한 디자인</h2>
                                        <p> entryContent(소본문) : 소본문 소본문 </p>


                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <img src="../images/fashion/single-img1.png" alt="post-img1"
                                                    class="img-fluid mr-4 w-100">
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <img src="../images/fashion/single-img2.png" alt="post-img2"
                                                    class="img-fluid mr-4 w-100">
                                            </div>
                                        </div>
                                        <h3 class="mt-5 mb-3">endTitle :  끝제목 </h3>

                                        <p>endContent : 끝본문   </p>


                                    </div>




                                    <div
                                        class="tags-share-box center-box d-flex text-center justify-content-between border-top border-bottom py-3">

                                        <span class="single-comment-o"><i class="fa fa-comment-o"></i>0 comment : 댓글</span>

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
                            <img alt="" src="../images/author.jpg" class="avatar avatar-100 photo" width="100"
                                height="100">
                        </div>

                        <div class="author-content pl-4">
                            <h4 class="mb-3"><a href="#" title="" rel="author" class="text-capitalize">userId : 유저아이디</a>
                            </h4>
                            <p>content : 댓글내용</p>


                        </div>
                    </div>



                    <div class="comment-area my-5">
                        <h3 class="mb-4 text-center">2 Comments</h3>
                        <div class="comment-area-box media">
                            <img alt="" src="../images/blog-user-2.jpg" class="img-fluid float-left mr-3 mt-2">

                            <div class="media-body ml-4">
                                <h4 class="mb-0">Micle harison </h4>
                                <span class="date-comm font-sm text-capitalize text-color"><i
                                        class="ti-time mr-2"></i>June 7, 2019 </span>

                                <div class="comment-content mt-3">
                                    <p>Lorem ipsum dolor sit amet, usu ut perfecto postulant deterruisset, libris causae
                                        volutpat at est, ius id modus laoreet urbanitas. Mel ei delenit dolores.</p>
                                </div>
                                <div class="comment-meta mt-4 mt-lg-0 mt-md-0">
                                    <a href="#" class="text-underline ">Reply</a>
                                </div>
                            </div>
                        </div>

                        <div class="comment-area-box media mt-5">
                            <img alt="" src="../mages/blog-user-3.jpg" class="mt-2 img-fluid float-left mr-3">

                            <div class="media-body ml-4">
                                <h4 class="mb-0 ">John Doe </h4>
                                <span class="date-comm font-sm text-capitalize text-color"><i
                                        class="ti-time mr-2"></i>June 7, 2019 </span>

                                <div class="comment-content mt-3">
                                    <p>Some consultants are employed indirectly by the client via a consultancy staffing
                                        company. </p>
                                </div>
                                <div class="comment-meta mt-4 mt-lg-0 mt-md-0">
                                    <a href="#" class="text-underline">Reply</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form class="comment-form mb-5 gray-bg p-5" id="comment-form">
                        <h3 class="mb-4 text-center">Leave a comment</h3>
                        <div class="row">
                            <div class="col-lg-12">
                                <textarea class="form-control mb-3" name="comment" id="comment" cols="30" rows="5"
                                    placeholder="Comment"></textarea>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="name" id="name" placeholder="Name:">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="mail" id="mail" placeholder="Email:">
                                </div>
                            </div>
                        </div>

                        <input class="btn btn-primary" type="submit" name="submit-contact" id="submit_contact"
                            value="Submit Message">
                    </form>

                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="sidebar sidebar-right">
                        <div class="sidebar-wrap mt-5 mt-lg-0">
                            <div class="sidebar-widget about mb-5 text-center p-3">
                                <div class="about-author">
                                    <img src="../images/author.jpg" alt="" class="img-fluid">
                                </div>
                                <h4 class="mb-0 mt-4">Liam Mason</h4>
                                <p>Travel Blogger</p>
                                <p>I'm Liam, last year I decided to quit my job and travel the world. You can follow my
                                    journey on this blog!</p>
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
                                        <h4><a href="blog-single.html">Meeting With Clarissa, Founder Of Purple
                                                Conversation App</a></h4>
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
    <!-- initialize jQuery Library -->
    <script src="../plugins/jquery/jquery.js"></script>
    <!-- Bootstrap jQuery -->
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../plugins/bootstrap/js/popper.min.js"></script>
    <!-- Owl caeousel -->
    <script src="../plugins/owl-carousel/owl.carousel.min.js"></script>
    <script src="../plugins/slick-carousel/slick.min.js"></script>
    <script src="../plugins/magnific-popup/magnific-popup.js"></script>
    <!-- Instagram Feed Js -->
    <script src="../plugins/instafeed-js/instafeed.min.js"></script>
    <!-- Google Map -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
    <script src="../plugins/google-map/gmap.js"></script>
    <!-- main js -->
    <script src="../js/custom.js"></script>


</body>

</html>