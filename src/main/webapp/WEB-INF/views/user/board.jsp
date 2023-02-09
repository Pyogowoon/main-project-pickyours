<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/userheader.jsp"%>
<header>


</header>
<main class="main">
	<section class="container">
		<!--전체 리스트 시작-->

		<article class="story-list" id="storyList">

			<!--전체 리스트 아이템-->






           <!-- 전체 리스트 아이템 End -->
		</article>
<aside>


                <div class="recommend" onclick="javascript:location.href='/'" ><img src="/images/left.png" style="height: 56px;width:56px"></div>

                <span> 다른사람도 구독해보세요 ! </span>


                 <c:forEach var="item" items="${user}">
                     <div class="subs">
                <br/>
                <span> ${item.id} </span>
                <span>  ${item.name}</span>
                <button class="cta" onclick="toggleSubscribe(${dto.user.id},this)">구경하기</button>
                   </div>
                  </c:forEach>



            </aside>



	</section>
</main>


<script src="/js/user/board.js"></script>
</body>
</html>