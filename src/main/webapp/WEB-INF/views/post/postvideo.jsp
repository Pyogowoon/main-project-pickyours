<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>


	<head>
<!--
		<link rel='stylesheet' href='/css/post/video.css'>
		-->


		 <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
                <link href="https://vjs.zencdn.net/7.10.2/video-js.css" rel="stylesheet" />
                <script src="https://vjs.zencdn.net/7.10.2/video.min.js"></script>

                <link href="https://unpkg.com/@silvermine/videojs-quality-selector/dist/css/quality-selector.css" rel="stylesheet">
                <script src="https://unpkg.com/@silvermine/videojs-quality-selector/dist/js/silvermine-videojs-quality-selector.min.js"></script>
	</head>

	<body>
<div id='video_play' >
	<div class='video_contain' onmousemove='video_play.mousemove()'>
    					<div class='adbuttons'>
    						<div>
    							<button type='button' onclick='video_play.back(this.form)'>
    								<i class="fa-solid fa-arrow-left-long"></i>
    							</button>
    						</div>
    						<div>
    							<button type='button' onclick='video_play.ad_toggle("의류")'>
    								<i class="fa-solid fa-shirt"></i>
    							</button>
    						</div>
    						<div>
    							<button type='button' onclick='video_play.ad_toggle("장소")'>
    								<i class="fa-solid fa-map-location-dot"></i>
    							</button>
    						</div>
    						<div class='video_flag' >
    							<button type='button' onclick=''><i class="fa-regular fa-flag"></i></button>
    						</div>
    					</div>
	 <video id="video2" class="video-js vjs-default-skin" controls preload="auto" width="640" height="268" data-setup='{}'>
	    <source src="http://media.w3.org/2010/05/sintel/trailer.mp4" >


      Your browser does not support the video tag.</video>
	</div>





</div>

 <div class="subscribe">
    				<ul>
    					<li><a href=""> 게시물<span>${dto.imageCount}</span>
    					</a></li>
    					<li><a href="javascript:subscribeInfoModalOpen(${dto.user.id});"> 구독정보<span>${dto.subscribeCount}</span>
    					</a></li>
    				</ul>
    			</div>


<!-- 구독정보 모달 -->

<div class="modal-subscribe">
	<div class="subscribe">
		<div class="subscribe-header">
			<span>구독정보</span>
			<button onclick="modalClose()">
				<i class="fas fa-times"></i>
			</button>
		</div>

		<div class="subscribe-list" id="subscribeModalList">



		</div>
	</div>

</div>

<!-- 구독정보 모달 end-->




	</body>


<script src="/js/post/video.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/videojs-contrib-hls/5.15.0/videojs-contrib-hls.min.js"></script>
		<script src="https://vjs.zencdn.net/7.19.2/video.min.js"></script>