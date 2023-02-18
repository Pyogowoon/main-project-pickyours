


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

