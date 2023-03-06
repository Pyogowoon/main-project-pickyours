/**
    게시글 저장
    (1) 게시글 저장하기
    (2) 착장 정보 사진 띄우기
    (3) 옷 정보 사진 띄우기
    (4) 비디오 정보 사진 띄우기


*/

// (1) 게시글 저장하기
function postSave(userId) {

    let data = $("#postSave")[0];

    let formData = new FormData(data);

    $.ajax({
        type: "post",
        data: formData,
        url: "/api/post",
        contentType: false,
        processData: false,
        enctype: "multipart/form-data",
        dataType: "json"

    }).done(res => {

       location.href = "/post";

    }).fail(error => {

        alert("모든 항목을 입력해야 저장 가능합니다.");

    });

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


// (3) 옷 정보 사진 띄우기
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

// (4) 비디오 정보 사진 띄우기
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