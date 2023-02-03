


function postComment(postId){

        let content = $("#postContent");

    console.log(content);


     let data = {
                 postId : postId,
             content : content.val()

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

        $("#commentContent").append("푸하하");



     }).fail( error => {
        console.log(error,"실패");

     });





}