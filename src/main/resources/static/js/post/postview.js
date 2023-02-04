


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

        console.log("잘됨");
        console.log(commentId);

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