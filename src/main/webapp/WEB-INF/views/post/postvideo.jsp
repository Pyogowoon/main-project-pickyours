<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>


	<head>

		<link rel='stylesheet' href='/css/post/video.css'>
		 <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/0323ea36d6.js" crossorigin="anonymous"></script>
	</head>

	<body>

<div id='video_play' >





            <!-- videoContents -->
        <div class="videoContents">
	 <video id="video2"  controls preload="auto" width="640" height="268" data-setup='{}'>
	    <source src="http://media.w3.org/2010/05/sintel/trailer.mp4" >


      Your browser does not support the video tag.</video>

     <!-- shopInfo -->
      <div class="shopInfo">
   옷 정보가 올 자리입니다.


      </div>

       <!-- shopInfo End -->

    <!-- actorInfo -->
      <div class="actorInfo">
        배우 정보 올 자리입니다.
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

            <!-- videoContents End-->


<i class="fas fa-times"></i>



	</div>





</div>

 <div class="subscribe">
    				<ul>

    					</li>
    					<li><a href="javascript:subscribeInfoModalOpen()"> 미래의플레이버튼</span>
    					</a></li>
    				</ul>

    			</div>






	</body>


<script src="/js/post/video.js"></script>
