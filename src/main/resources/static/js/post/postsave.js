


      function postSave(userId){
                alert(userId);

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

                }).done( res => {
           location.href="/post/post";
                alert("성공");
                }).fail(error =>{
                console.log(error,"실패");
                alert(error,"저장 실패");
                });

            }

