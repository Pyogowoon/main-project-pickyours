<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/userheader.jsp"%>

<main class="main">
	<section class="container">
		<!--전체 리스트 시작-->

		<article class="story-list" id="storyList">

<br/>
   <div class="form-outline">
         <form action="/user/board/search/name" method="get" name="search" id="searchForm">
          <input type="search" id="form1" name="keyword" class="form-control" placeholder="찾으시는 닉네임을 입력해주세요." />
        <button class="btn btn-primary" style="height:35px;width:60px;">
                <i class="fas fa-search"></i>
                  </button>
                  </form>
        </div>
			<!--전체 리스트 아이템-->






           <!-- 전체 리스트 아이템 End -->
		</article>
<aside>


                <div class="back" onclick="javascript:history.back()" style="cursor:pointer" ><img src="/images/left.png" style="height: 56px;width:56px"></div>



                 <div class="recommend">

                <span class="recTitle">다른사람도 구독해보세요!</span>


                 <c:forEach var="item" items="${user}" begin="0" end="3">
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
<script src="/js/user/fontawesome.js"></script>
<script src="/js/user/jquery.js"></script>
</body>
</html>