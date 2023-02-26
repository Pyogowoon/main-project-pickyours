/**
    게시글 수정
    (1) 게시글 수정하기
    (2) 착장 정보 사진 띄우기
    (3) 옷 정보 사진 띄우기
    (4) 비디오 정보 사진 띄우기


*/

// (1) 게시글 수정하기
function postUpdate(postId) {

    let data = $("#postUpdate")[0];
    console.log(data)

    let formData = new FormData(data);

    $.ajax({
        type: "PUT",
        url: `/api/post/postupdate/${postId}`,
        data: formData,
        contentType: false,
        processData: false,
        enctype: "multipart/form-data",
        dataType: "json"

    }).done(res => {

        alert("수정이 완료되었습니다.");
        location.href = "/post";


    }).fail(error => {
        alert("수정 권한이 없습니다. 관리자에게 문의하세요.");
    })




}

// (2) 착장 정보 사진 띄우기
function setThumbnail(event) {

    var reader = new FileReader();

    reader.onload = function(event) {
        var img = document.createElement("img");
        img.setAttribute("src", event.target.result);
         $('#imageContainer').empty();
        document.querySelector("div#imageContainer").appendChild(img);
    };

    reader.readAsDataURL(event.target.files[0]);
}

// (3) 옷 사진 정보 띄우기
function setThumbnail2(event) {
    var reader = new FileReader();

    reader.onload = function(event) {
        var img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        $('#clothesContainer').empty();
        document.querySelector("div#clothesContainer").appendChild(img);
    };

    reader.readAsDataURL(event.target.files[0]);
}

// (4) 비디오 사진 정보 띄우기
function setThumbnailVideo(event) {
    var reader = new FileReader();

    reader.onload = function(event) {
        var img = document.createElement("video");
        img.setAttribute("src", event.target.result);
           $('#videoContainer').empty();
        document.querySelector("div#videoContainer").appendChild(img);
    };

    reader.readAsDataURL(event.target.files[0]);
}