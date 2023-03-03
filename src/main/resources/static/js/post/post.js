/**
  게시글 불러오기
    (1) 게시글 불러오기

 */

 // (1) 게시글 불러오기
let page = 0;

function postLoad() {

     $.ajax({

            type: "get",
            url: `/api/post?page=${page}`,
            dataType: "json"

        }).done(res => {

        }).fail(error => {

        });


}

postLoad();