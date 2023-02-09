


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

                alert("저장 권한이 없습니다. 관리자에게 문의하세요.");
                });

            }

