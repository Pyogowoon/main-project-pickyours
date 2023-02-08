


      function postUpdate(postId){
      alert("업데이트 실행됨");
      console.log("postId : " , postId)


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
        console.log(res,"업데이트 성공");
        console.log("res.data : " ,res.data);
      }).fail(error =>{
        console.log(error,"업데이트 실패");
      })




          }

