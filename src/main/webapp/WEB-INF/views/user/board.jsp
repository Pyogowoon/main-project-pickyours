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


                <div class="back" onclick="javascript:location.href='/'" ><img src="/images/left.png" style="height: 56px;width:56px"></div>



                 <div class="recommend">

                <span>다른사람도 구독해보세요!</span>


                 <c:forEach var="item" items="${user}" begin="0" end="5">
                     <div class="subs">
                <br/>
               <img class="profile-image" src="/upload/${item.profileImageUrl}" style="width:50px;height:50px;"
               							onerror="this.src='/images/person.jpeg'" />
                    <span class="text-box">
                <span class="username">  ${item.name}</span>
                <button class="cta" onclick="javascript:location.href='/user/${item.id}'" style="cursor:pointer; cursor:hand;">구경하기</button>
                            </span>
                   </div>
                  </c:forEach>

                    </div>

            </aside>



	</section>
</main>


<script src="/js/user/board.js"></script>
</body>
</html>