<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/userheader.jsp" %>
<main class="main">
    <section class="container">
        <!--전체 리스트 시작-->
        <article class="story-list" id="storyList">

            <!--전체 리스트 아이템-->
            <div class="story-list__item" id="contentsItem-${image.id}">
                <div class="sl__item__header">

                    <div>
                        <img class="profile-image" src="/upload/${image.user.profileImageUrl}"
                            onerror="this.src='/images/person.jpeg'" />
                    </div>


                    <div class="sl__item__contents__delete">
                        <span onclick="location.href='/user/${image.user.id}'">${image.user.name} </span>

                         <span class="crud">
                                               <button type="button" class onclick="location.href='/image/upload/${image.id}'" style="border:none;outline:none;background:white;margin-right:20px;cursor:pointer; cursor:hand;">  <i class="fa-solid fa-pen-to-square"></i></button>
                        					     <button type="button" class onclick="contentsDelete(${image.id},principalId)" style="border:none;outline:none;background:white;margin-right:20px;cursor:pointer; cursor:hand;"><i class="fas fa-times"></i></button>
                        					     </span>
                    </div>


                </div>
                <div class="sl__item__img">
                    <a href="/user/boardview/${image.id}">
                    <img src="/upload/${image.postImageUrl}" style="width:65%; height:600px;" />
                    </a>
                </div>


                <div class="sl__item__contents">
                    <div class="sl__item__contents__icon">

                    <c:choose>

                     <c:when test="${image.likeState == true}">
                        <button>
                       <i class="fas fa-heart active" id="storyLikeIcon-${image.id}" onclick="toggleLike(${image.id})"></i>
                        </button>

                     </c:when>

                     <c:otherwise>
                        <button>
                        <i class="fa-heart far" id="storyLikeIcon-${image.id}" onclick="toggleLike(${image.id})"></i>
                        </button>

                     </c:otherwise>


                    </c:choose>

                    </div>

                    <span class="like"><b id="storyLikeCount-${image.id}">${image.likes.size()}</b>likes</span>

                    <div class="sl__item__contents__content">
                        <p>${image.caption}

                        </p>
                        <br/>
                        <hr />
                        <br/>
                    </div>
                      <c:forEach var="comment" items="${image.comments}">
                    <div id="storyCommentList-${image.id}">

<div class="sl__item__contents__comment" id="storyCommentItem-${comment.id}">
                                <p>
                  <span onclick="location.href='/user/${comment.user.id}'">  <b>${comment.user.name} </span>  :  </b> ${comment.content}
                                </p>

                            <c:choose>
                             <c:when test="${comment.user.id == principal.user.id || principal.user.role == 'ADMIN'}">
                                 <button type="button" onclick="deleteComment(${comment.id})">
                                                                    <i class="fas fa-times"></i>
                                 </button>
                             </c:when>
                            </c:choose>

                    </div>
                       </c:forEach>
                    <div class="sl__item__input">
                        <input type="text" placeholder="댓글 달기..." id="storyCommentInput-${image.id}" />
                        <button type="button" onClick="addComment(${image.id})">게시</button>
                    </div>
                </div>
            </div>
            <!-- 전체 리스트 아이템 End -->
        </article>
        <aside>
            <div class="back" onclick="javascript:history.back()"><img src="/images/left.png" style="height: 56px;width:56px">
            </div>

        </aside>
    </section>
</main>

<script src="/js/user/boardview.js"></script>
<script src="/js/user/fontawesome.js"></script>
<script src="/js/user/jquery.js"></script>

</body>
</html>