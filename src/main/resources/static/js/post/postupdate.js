


      function postUpdate(postId){

         let data = $("#postUpdate")[0];
         console.log(data)

          let formData = new FormData(data);

      $.ajax({
      type:"PUT",
      url:`/api/post/postupdate/${postId}`,
      data: formData,
      contentType:false,
      processData:false,
      enctype:"multipart/form-data",
      dataType:"json"

      }).done(res =>{

       alert("수정이 완료되었습니다.");
        location.href="/post";


      }).fail(error =>{
        alert("수정 권한이 없습니다. 관리자에게 문의하세요.");
      })




          }

