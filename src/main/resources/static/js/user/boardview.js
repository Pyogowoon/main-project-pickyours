/**
    (1) 좋아요, 안좋아요
    (2) 댓글달기
    (3) 댓글삭제


*/


// (1) 좋아요 , 안좋아요
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
//(2) 댓글달기
function addComment(imageId) {

    let commentInput = $(`#storyCommentInput-${imageId}`);
    let commentList = $(`#storyCommentList-${imageId}`);

    let data = {
        imageId: imageId,
        content: commentInput.val()
    }



    if (data.content === "") {
        alert("댓글을 작성해주세요.");
        return;
    }

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

// (3) 댓글 삭제
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
