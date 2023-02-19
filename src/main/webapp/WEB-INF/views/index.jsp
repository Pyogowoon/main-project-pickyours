<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
      <!-- Basic -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Site Metas -->
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <link rel="shortcut icon" href="images/favicon.png" type="">
      <title>Pick Yours! 픽유얼스에 오신걸 환영합니다.</title>

   </head>
   <body>
   <!-- header -->
<header>

   <%@ include file="./layout/indexheader.jsp"%>

</header>
   <!-- header End -->

    <!-- slider section -->
         <section class="slider_section ">
            <div class="slider_bg_box">
               <img src="images/background3.png"  alt="">
            </div>
            <div id="customCarousel1" class="carousel slide" data-ride="carousel">
               <div class="carousel-inner">
                  <div class="carousel-item active">
                     <div class="container ">
                        <div class="row">
                           <div class="col-md-7 col-lg-6 ">
                              <div class="detail-box">
                                 <h1>
                                    <span>
                                  Pick yours!
                                    </span>
                                    <br>
                                    On Everything
                                 </h1>
                                 <p class="hangle">
                                      Pick yours 의 유저마당 서비스로 당신이 원하는 정보를 찾고 공유해보세요!
                                 </p>
                                 <div class="btn-box">
                                    <a href="/user/board" class="btn1" id="hangle">
                                   유저마당 보기
                                    </a>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="carousel-item ">
                     <div class="container ">
                        <div class="row">
                           <div class="col-md-7 col-lg-6 ">
                              <div class="detail-box">
                                 <h1>
                                    <span>
                                   Pick yours!
                                    </span>
                                    <br>
                                    On Everything
                                 </h1>
                                 <p class="hangle">
                                    Pick yours 의 블로그 서비스로 당신이 원하는 정보를 검색하고 찾아보세요!
                                 </p>
                                 <div class="btn-box">
                                    <a href="/post" class="btn1" id="hangle">
                                    블로그 보기
                                    </a>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="carousel-item">
                     <div class="container ">
                        <div class="row">
                           <div class="col-md-7 col-lg-6 ">
                              <div class="detail-box">
                                 <h1>
                                    <span>
                                    Pick yours!
                                    </span>
                                    <br>
                                    On Everything
                                 </h1>
                                 <p class="hangle">
                                   Pick yours 의 소셜 서비스와 블로그 서비스를 경험해보세요!
                                 </p>
                                 <div class="btn-box">
                                    <a href="/auth/signin" class="btn1" id="hangle">
                                    로그인하기
                                    </a>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="container">
                  <ol class="carousel-indicators">
                     <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
                     <li data-target="#customCarousel1" data-slide-to="1"></li>
                     <li data-target="#customCarousel1" data-slide-to="2"></li>
                  </ol>
               </div>


            </div>
         </section>
         <!-- end slider section -->





           <!-- jQuery -->
               <script src="js/index/jquery-3.4.1.min.js"></script>
               <!-- popper js -->
               <script src="js/index/popper.min.js"></script>
               <!-- bootstrap js -->
               <script src="js/index/bootstrap.js"></script>
               <!-- custom js -->
               <script src="js/index/custom.js"></script>


                 <!-- footer -->


                  <%@ include file="./layout/footer.jsp"%>


                  <!-- footer End -->
</body>
</html>