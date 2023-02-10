


function postComment(postId){

    let content = $("#postContent");
    let profile = $("#profileImage");
    let username = $("#profileUsername");

    console.log(profile);
    console.log(username);

     let data = {
                 postId : postId,
             content : content.val(),
             profile : profile.val(),
             username : username.val()
     	}


     $.ajax({
        type:"post",
        url:`/api/post/comment/${postId}`,
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"json"


     }).done(res => {
        console.log("성공");
        console.log(res.data);

        let comment = res.data.content;
        let user = res.data.commentUser;
        let profile = res.data.user.profileImageUrl;
        let createDate = res.data.createDate;
        let onerror="this.src='/images/person.jpeg";
        let commentId = res.data.id;

        let commentCountStr = $("#commentSize").text();
        let commentCount = Number(commentCountStr)+1;

         $("#commentSize").text(commentCount);


        $("#commentContent").append("<span class='test' id='deleteArea-"+commentId+"'>"
        +"<span class='delete' onclick='deleteButton("+commentId+")' style='cursor:pointer; cursor:hand;'>X</span>"
        +"<img alt='' src='/upload/"+profile+"' onerror="+onerror+"' style='height: 70px;width:90px' class='img-fluid float-left mr-3 mt-2'>"
        +"<div class=media-body ml-4>"
        +"<h4 class='mb-0'>"+user+"</h4>"
        +"<span class='date-comm font-sm text-capitalize text-color'><i class='ti-time mr-2'></i>"+createDate+"</span>"
        +"<div class='comment-content mt-1' id='commentContent'>"
        +"<p>"+comment+"</p>"
        +"</div>"
        +"</br>"
        +"</div>"
        +"</div>"
         );


        content.val('');

     }).fail( error => {
        console.log(error,"실패");

     });

}

    function deleteButton(commentId){

        $.ajax({

            type:"delete",
            url:`/api/post/comment/${commentId}`,
            dataType:"json"

        }).done(res => {
            console.log(res,"댓글 삭제 성공");
            alert("댓글을 삭제하시겠습니까? ");

            $("#deleteArea-"+commentId).remove();
             let commentCountStr = $("#commentSize").text();
             let commentCount = Number(commentCountStr)-1;

            $("#commentSize").text(commentCount);


        }).fail(error => {
            console.log(error ,"댓글 삭제 실패");
            alert("해당 댓글 아이디의 주인이 아닙니다.");

        });

    }

    function toggleLike(postId){


    let likeIcon = $(`#postLikeIcon-${postId}`);
    	if (likeIcon.hasClass("far")) {

    $.ajax({

        type:"post",
        url:`/api/post/likes/${postId}`,
        dataType:" json"

        }).done(res =>{
        console.log(res, "좋아요 성공");


         let likeCountStr = $("#likeSize").text();
         let likeCount = Number(likeCountStr)+1;

         $("#likeSize").text(likeCount);

         $("#toggle").removeAttr("onclick");
         $("#toggle").attr("onclick","toggleUnLike("+postId+")");
         $("#postLikeIcon-"+postId+"").attr("id","postUnLikeIcon-"+postId+"");


        }).fail(error =>{
        console.log(error , "좋아요 실패");
         alert("좋아요 시도 실패.")
        });

}
            likeIcon.removeClass("fa-heart far");
        		likeIcon.addClass("fas fa-heart active");


    }




    function toggleUnLike(postId){


     let unlikeIcon = $(`#postUnLikeIcon-${postId}`);
        if (unlikeIcon.hasClass("active")) {

     $.ajax({

          type:"delete",
          url:`/api/post/likes/${postId}`,
          dataType:"json"

          }).done(res => {
          console.log(res,"좋아요 취소 성공");


          let likeCountStr = $("#likeSize").text();
          let likeCount = Number(likeCountStr)-1;

           $("#likeSize").text(likeCount);

            $("#toggle").removeAttr("onclick");
            $("#toggle").attr("onclick","toggleLike("+postId+")");
            $("#postUnLikeIcon-"+postId+"").attr("id","postLikeIcon-"+postId+"");



          }).fail(error => {
           console.log(error,"좋아요 취소 실패");
           alert("좋아요 취소를 실패했습니다.")
          });


        }

        unlikeIcon.removeClass("fas fa-heart active");
        unlikeIcon.addClass("fa-heart far");




    }

    function postDelete(postId){
        confirm("정말 삭제하시겠습니까?");

    $.ajax({
        type:"delete",
        url:`/api/post/delete/${postId}`,
        dataType:"json"

    }).done(res => {
      console.log("성공",res)
       location.href="/post";
    }).fail(error => {
      console.log("실패",error)
    })

    }

function modalOpen() {
  console.log("작동");
     $(".videoContents").css("display", "flex");
     $("#video2").css("display", "flex");

}


/* 모달 닫기 */
function modalClose() {
	$(".videoContents").css("display", "none");
    document.getElementById("video2").pause();
}

function toggle(){
$(".actorInfo").css("display", "none");
  $(".shopInfo").toggle();

}

function actorToggle(){
$(".shopInfo").css("display", "none");
   $(".actorInfo").toggle();
}
