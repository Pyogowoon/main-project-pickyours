


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

        console.log(res.data.commentUser);
        console.log(res.data.content);

        let comment = res.data.content;
        let user = res.data.commentUser;
        let profile = res.data.user.profileImageUrl;
        let createDate = res.data.createDate;



        let div= "${post.id}";

        $("#commentContent").append("<img alt='' src='/upload/"+profile+"' style='height: 70px;width:90px' class='img-fluid float-left mr-3 mt-2'>"
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
                                                        onerror="this.src='/images/person.jpeg'"

     }).fail( error => {
        console.log(error,"실패");

     });

}


//function addComment(){
//
//<img alt="" src="/upload/${post.user.profileImageUrl}" style="height: 70px;width:90px" class="img-fluid float-left mr-3 mt-2">
// <div class="media-body ml-4">
//   <h4 class="mb-0">"${list.commentUser}" </h4>
//      <span class="date-comm font-sm text-capitalize text-color"><i class="ti-time mr-2"></i>createDate </span>
//       <div class="comment-content mt-1" id="commentContent">
//
//         </div>
//                            </br>
//                            </div>
//                        </div>
//
//
//
//
//}


// "<img alt="" src="/upload/${post.user.profileImageUrl}" style="height: 70px;width:90px" class="img-fluid float-left mr-3 mt-2">
//          <div class="media-body ml-4">
//            <h4 class="mb-0">"${list.commentUser}" </h4>
//               <span class="date-comm font-sm text-capitalize text-color"><i class="ti-time mr-2"></i>createDate </span>
//                <div class="comment-content mt-1" id="commentContent">
//
//                  </div>
//                                     </br>
//                                     </div>
//                                 </div>