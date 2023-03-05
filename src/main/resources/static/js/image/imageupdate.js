/**
    유저마당 게시글 업로드
    (1) 스토리 이미지 업로드를 위한 사진 선택 로직
    (2) 업로드 수정하기


*/



// (1) 스토리 이미지 업로드를 위한 사진 선택 로직
function imageChoose(obj) {
	let f = obj.files[0];

	if (!f.type.match("image.*")) {
		alert("이미지를 등록해야 합니다.");
		return;
	}

	let reader = new FileReader();
	reader.onload = (e) => {
		$("#imageUploadPreview").attr("src", e.target.result);
	}
	reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
}

// (2) 업로드 수정하기
function imageUpdate(imageId){

        let data=$("#imageUpdate")[0];
        let formData = new FormData(data);

        $.ajax({
            type:"PUT",
            url:`/api/image/${imageId}/`,
            data: formData,
            contentType: false,
            processData: false,
            enctype: "multipart/form-data",
            dataType: "json"


        }).done(res => {
           alert("수정을 완료하였습니다.")
          location.href = "/user/board";
        }).fail(error =>{
           alert("수정에 실패하였습니다. 관리자에게 문의하세요.");

        })




}