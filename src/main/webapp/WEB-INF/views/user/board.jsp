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
                <div class="recommend"> 뒤로가기 </div>
                <div class="subs">
                <button class="cta" onclick="toggleSubscribe(${dto.user.id},this)">구독하기</button>
                </div>
            </aside>
	</section>
</main>


<script src="/js/user/board.js"></script>
</body>
</html>