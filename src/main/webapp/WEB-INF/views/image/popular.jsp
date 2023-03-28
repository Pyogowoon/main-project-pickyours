<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/userheader.jsp"%>

<!--인기 게시글-->
<main class="popular">
	<div class="exploreContainer">

		<!--인기게시글 갤러리(GRID배치)-->
		<div class="popular-gallery">

		<div class="back" onclick="javascript:history.back()" style="cursor:pointer" ><img src="/images/left.png" style="height: 56px;width:56px"></div>


          <c:forEach var="image" items="${images}">
	<div class="p-img-box">
				<a href="/user/board/${image.id}"> <img src="/upload/${image.postImageUrl}" />
				</a>
			</div>

          </c:forEach>

		</div>

	</div>
</main>

<script src="/js/user/fontawesome.js"></script>
<script src="/js/user/jquery.js"></script>



