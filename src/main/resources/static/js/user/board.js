/**
	 유저마당
	(1) 스토리 로드하기
	(2) 스토리 스크롤 페이징하기
	(3) 좋아요, 안좋아요
	(4) 댓글쓰기
	(5) 댓글삭제
	(6) 콘텐츠 삭제
 */
// (0) 현재 로그인한 사용자 아이디
let principalId = $("#principalId").val();
let principalRole = $("#principalRole").val();




let page = 0;

// (1) 스토리 로드하기
function storyLoad() {

    $.ajax({

        type: "get",
        url: `/api/image?page=${page}`,
        dataType: "json"

    }).done(res => {

        res.data.content.forEach((image) => {

            let storyItem = getStoryItem(image);

            $("#storyList").append(storyItem);

        });

    }).fail(error => {
        console.log(error, "실패");
    });


}

storyLoad();


function getStoryItem(image) {
    let item = `
<div class="story-list__item" id="contentsItem-${image.id}">
				<div class="sl__item__header" >
					<div>
						<img class="profile-image" src="/upload/${image.user.profileImageUrl}"
							onerror="this.src='/images/person.jpeg'" />
					</div>
					  <div class="sl__item__contents__delete">
					   <span onclick="location.href='/user/${image.user.id}'">${image.user.name} </span>
                        `;
    if (principalId == image.user.id || principalRole == "ADMIN" || principalRole == "SUPERADMIN") {
        item += `
        <span class="crud">
                       <button type="button" class onclick="location.href='/image/upload/${image.id}'" style="border:none;outline:none;background:white;margin-right:20px;cursor:pointer; cursor:hand;">  <i class="fa-solid fa-pen-to-square"></i></button>
					     <button type="button" class onclick="contentsDelete(${image.id},principalId)" style="border:none;outline:none;background:white;margin-right:20px;cursor:pointer; cursor:hand;"><i class="fas fa-times"></i></button>
					     </span>
					     `;
    }
    item += `
					   </div>




				</div>

				<div class="sl__item__img">
				<a href="/user/board/${image.id}">
					<img src="/upload/${image.postImageUrl}" style="width:65%; height:600px;" />
					</a>
				</div>

				<div class="sl__item__contents">
					<div class="sl__item__contents__icon">

						<button>`;
    if (image.likeState) {   item += `<i class="fas fa-heart active" id="storyLikeIcon-${image.id}" onclick="toggleLike(${image.id})"></i>
     	`;
    } else {
        item += ` <i class="fa-heart far" id="storyLikeIcon-${image.id}" onclick="toggleLike(${image.id})"></i> `;
    }


    item += `
						</button>
					</div>

					<span class="like"><b id="storyLikeCount-${image.id}">${image.likeCount}</b>좋아요</span>

					<div class="sl__item__contents__content">
						<p>${image.caption}</p>

                        <br/>
						<hr/>
                        <br/>
					</div>

					<div id="storyCommentList-${image.id}">`;

    image.comments.forEach((comment) => {

        item +=
            ` <div class="sl__item__contents__comment" id="storyCommentItem-${comment.id}">
                                <p>
                  <span onclick="location.href='/user/${comment.user.id}'">  <b>${comment.user.name} </span>  :  </b> ${comment.content}
                                </p>`;

        if (principalId == comment.user.id || principalRole == "ADMIN" || principalRole == "SUPERADMIN") {
            item +=
                `
                                <button type="button" onclick="deleteComment(${comment.id})">
                                    <i class="fas fa-times"></i>
                                </button>
                                `;
        }
        item += `
                            </div>`;


    });



    item += `

					</div>
					<div class="sl__item__input">
						<input type="text" placeholder="댓글 달기..." id="storyCommentInput-${image.id}" />
						<button type="button" onClick="addComment(${image.id})">게시</button>
					</div>
				</div>
			</div>`;
    return item;

}

// (2) 스토리 스크롤 페이징하기
$(window).scroll(() => {

    let checkNum = $(window).scrollTop() - ($(document).height() - $(window).height());

    if (checkNum < 1.5 && checkNum > -1.5) {
        page++;
        storyLoad();
    }

});


// (3) 좋아요, 안좋아요
function toggleLike(imageId) {
    let likeIcon = $(`#storyLikeIcon-${imageId}`);
    if (likeIcon.hasClass("far")) {

        $.ajax({
            type: "post",
            url: `/api/image/${imageId}/likes`,
            dataType: "json"

        }).done(res => {


            let likeCountStr = $(`#storyLikeCount-${imageId}`).text();
            let likeCount = Number(likeCountStr) + 1;
            $(`#storyLikeCount-${imageId}`).text(likeCount);


        }).fail(error => {
            alert("좋아요에 실패하였습니다. 관리자에게 문의하세요.")
        });

        likeIcon.addClass("fas");
        likeIcon.addClass("active");
        likeIcon.removeClass("far");

    } else {
        likeIcon.removeClass("fas");

        $.ajax({
            type: "delete",
            url: `/api/image/${imageId}/likes`,
            dataType: "json"
        }).done(res => {

            let likeCountStr = $(`#storyLikeCount-${imageId}`).text();
            let likeCount = Number(likeCountStr) - 1;
            $(`#storyLikeCount-${imageId}`).text(likeCount);
        }).fail(error => {
            alert("좋아요 취소에 실패하였습니다. 관리자에게 문의하세요.")
        });


        likeIcon.removeClass("active");
        likeIcon.addClass("far");
    }
}

// (4) 댓글쓰기
function addComment(imageId) {

    let commentInput = $(`#storyCommentInput-${imageId}`);
    let commentList = $(`#storyCommentList-${imageId}`);

    let data = {
        imageId: imageId,
        content: commentInput.val()
    }


//
//    if (data.content === "") {
//        alert("댓글을 작성해주세요.");
//        return;
//    }

    $.ajax({
        type: "post",
        url: "/api/comment",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"


    }).done(res => {

        let comment = res.data;

        let content = `
        			  <div class="sl__item__contents__comment" id="storyCommentItem-${comment.id}">
        			    <p>
        			      <b>${comment.user.name}</b>
        			         :   ${comment.content}
        			    </p>
        			    <button type="button" onclick="deleteComment(${comment.id})">
        			    <i class="fas fa-times"></i>
        			    </button>
        			  </div>
        	`;
        commentList.prepend(content);

    }).fail(error => {
        console.log(error.responseJSON.data.content, "댓글 달기 실패");
        alert(error.responseJSON.data.content);
    });



    commentInput.val("");
}

// (5) 댓글 삭제
function deleteComment(userId) {

    if (confirm('정말 삭제하시겠습니까?')) {

        $.ajax({
            type: "delete",
            url: `/api/comment/${userId}`,
            dataType: "json"

        }).done(res => {

            $(`#storyCommentItem-${userId}`).remove();
        }).fail(error => {
            console.log(error, "삭제 실패");


        });
    } else {
        return false;
    }
}

// (6) 콘텐츠 삭제
function contentsDelete(imageId, principalId) {

   if (confirm('정말 삭제하시겠습니까?')) {

    $.ajax({

        type: "delete",
        url: `/api/image/${imageId}`,
        dataType: "json"


    }).done(res => {

        $(`#contentsItem-${imageId}`).remove();

    }).fail(error => {
        alert("삭제에 실패하였습니다. 관리자에게 문의하세요.")
    })

    }else{
    return false;
    }

}