/**
	 블로그 상세보기

	 (1) 게시글 댓글달기
	 (2) 게시글 댓글삭제
	 (3) 좋아요
	 (4) 좋아요 취소
	 (5) 게시글 삭제
	 (6) 영상물 모달 열기
	 (7) 영상물 모달 닫기
	 (8) 영상물 옷 정보 토글
	 (9) 영상물 연예인 정보 토글

 */


//(1) 게시글 댓글달기
function postComment(postId) {

    let content = $("#postContent");
    let profile = $("#profileImage");
    let username = $("#profileUsername");



    let data = {

        postId: postId,
        content: content.val(),
        profile: profile.val(),
        username: username.val()
    }


    $.ajax({

        type: "post",
        url: `/api/post/comment/${postId}`,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"


    }).done(res => {

        let comment = res.data.content;
        let user = res.data.commentUser;
        let profile = res.data.user.profileImageUrl;
        let createDate = res.data.createDate;
        let onerror = "this.src='/images/person.jpeg";
        let commentId = res.data.id;

        let commentCountStr = $("#commentSize").text();
        let commentCount = Number(commentCountStr) + 1;

        $("#commentSize").text(commentCount);


        $("#commentContent").append("<span class='test' id='deleteArea-" + commentId + "'>" +
            "<span class='delete' onclick='postCommentDelete(" + commentId + ")' style='cursor:pointer; cursor:hand;'>X</span>" +
            "<img alt='' src='/upload/" + profile + "' onerror=" + onerror + "' style='height: 70px;width:90px' class='img-fluid float-left mr-3 mt-2'>" +
            "<div class=media-body ml-4>" +
            "<h4 class='mb-0'>" + user + "</h4>" +
            "<span class='date-comm font-sm text-capitalize text-color'><i class='fa-solid fa-clock'></i>" + createDate + "</span>" +
            "<div class='comment-content mt-1' id='commentContent'>" +
            "<p class='hangle'>" + comment + "</p>" +
            "</div>" +
            "</br>" +
            "</div>" +
            "</div>"
        );

        content.val('');

    }).fail(error => {

       alert("댓글달기에 실패하였습니다. 관리자에게 문의하세요.");

    });

}

// (2) 게시판 댓글삭제
function postCommentDelete(commentId) {
    if (confirm('정말 삭제하시겠습니까?')) {

        $.ajax({

            type: "delete",
            url: `/api/post/comment/${commentId}`,
            dataType: "json"

        }).done(res => {

            $("#deleteArea-" + commentId).remove();
            let commentCountStr = $("#commentSize").text();
            let commentCount = Number(commentCountStr) - 1;
            $("#commentSize").text(commentCount);

        }).fail(error => {

            alert("해당 댓글 아이디의 주인이 아닙니다.");

        });
    } else {
        return false;
    }
}


// (3) 좋아요
function toggleLike(postId) {

    let likeIcon = $(`#postLikeIcon-${postId}`);
    if (likeIcon.hasClass("far")) {

        $.ajax({

            type: "post",
            url: `/api/post/${postId}/likes`,
            dataType: " json"

        }).done(res => {

            let likeCountStr = $("#likeSize").text();
            let likeCount = Number(likeCountStr) + 1;

            $("#likeSize").text(likeCount);

            $("#toggle").removeAttr("onclick");
            $("#toggle").attr("onclick", "toggleUnLike(" + postId + ")");
            $("#postLikeIcon-" + postId + "").attr("id", "postUnLikeIcon-" + postId + "");


        }).fail(error => {

            alert("좋아요 시도 실패.")
        });

    }
    likeIcon.removeClass("fa-heart far");
    likeIcon.addClass("fas fa-heart active");


}

// (4) 좋아요 취소
function toggleUnLike(postId) {


    let unlikeIcon = $(`#postUnLikeIcon-${postId}`);
    if (unlikeIcon.hasClass("active")) {

        $.ajax({

            type: "delete",
            url: `/api/post/${postId}/likes`,
            dataType: "json"

        }).done(res => {
            console.log(res, "좋아요 취소 성공");


            let likeCountStr = $("#likeSize").text();
            let likeCount = Number(likeCountStr) - 1;

            $("#likeSize").text(likeCount);

            $("#toggle").removeAttr("onclick");
            $("#toggle").attr("onclick", "toggleLike(" + postId + ")");
            $("#postUnLikeIcon-" + postId + "").attr("id", "postLikeIcon-" + postId + "");



        }).fail(error => {
            console.log(error, "좋아요 취소 실패");
            alert("좋아요 취소를 실패했습니다.")
        });


    }

    unlikeIcon.removeClass("fas fa-heart active");
    unlikeIcon.addClass("fa-heart far");




}

// (5) 게시글 삭제
function postDelete(postId) {

    if (confirm('정말 삭제하시겠습니까?')) {

        $.ajax({
            type: "delete",
            url: `/api/post/${postId}`,
            dataType: "json"

        }).done(res => {

            location.href = "/post";
        }).fail(error => {
            alert("삭제에 실패했습니다. 관리자에게 문의하세요.");
        });

    } else {
        return false;
    }

}

// (6) 영상물 모달 열기
function modalOpen() {

    $(".videoContents").css("display", "flex");
    $("#video2").css("display", "flex");

}


// (7) 영상물 모달 닫기
function modalClose() {
    $(".videoContents").css("display", "none");
    document.getElementById("video2").pause();
}

// (8) 영상물 옷 정보 토글
function toggle() {
    $(".actorInfo").css("display", "none");
    $(".shopInfo").toggle();

}

// (9) 영상물 연예인 정보 토글
function actorToggle() {
    $(".shopInfo").css("display", "none");
    $(".actorInfo").toggle();
}


