


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

function setThumbnail(event) {

        var reader = new FileReader();

        reader.onload = function(event) {
          var img = document.createElement("img");
          img.setAttribute("src", event.target.result);
          document.querySelector("div#imageContainer").appendChild(img);
        };

        reader.readAsDataURL(event.target.files[0]);
      }


      function setThumbnail2(event) {
              var reader = new FileReader();

              reader.onload = function(event) {
                var img = document.createElement("img");
                img.setAttribute("src", event.target.result);
                document.querySelector("div#clothesContainer").appendChild(img);
              };

              reader.readAsDataURL(event.target.files[0]);
            }


 function setThumbnailVideo(event) {
              var reader = new FileReader();

              reader.onload = function(event) {
                var img = document.createElement("video");
                img.setAttribute("src", event.target.result);
                document.querySelector("div#videoContainer").appendChild(img);
              };

              reader.readAsDataURL(event.target.files[0]);
            }

