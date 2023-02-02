


function postComment(){

        let content = $("#postContent");

    console.log(content);


     let data = {

             content : content.val()
     	}


     $.ajax({
        type:"post",
        url:"/api/post/comment",
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"json"


     }).done(res => {

        console.log("성공");
        console.log(res.data)
     }).fail( error => {

        console.log(error,"실패");

     });





}