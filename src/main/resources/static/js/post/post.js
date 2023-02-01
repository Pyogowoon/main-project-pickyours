
      function postSave(){

            console.log("시발");
                let data = $("#postSave")[0];

                let formData = new FormData(data);

            $.ajax({
                type: "POST",
                data: formData,
                url: "/api/post/save/",
                contentType:false,
                processData:false,
                enctype:"multipart/form-data",
                dataType: "json"

                }).done( res => {
                console.log(res,"성공");
                alert(res,"저장 성공");

                }).fail(error =>{
                console.log(error,"실패");
                alert(error,"저장 실패");
                });

            }

