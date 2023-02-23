


      function postSave(userId){


                let data = $("#postSave")[0];

                let formData = new FormData(data);

            $.ajax({
                type:"post",
                data: formData,
                url: "/api/post/postsave",
                contentType:false,
                processData:false,
                enctype:"multipart/form-data",
                dataType: "json"

                }).done(res => {

               location.href="/post";

                }).fail(error =>{

                alert("모든 항목을 입력해야 저장 가능합니다.");

                });

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

