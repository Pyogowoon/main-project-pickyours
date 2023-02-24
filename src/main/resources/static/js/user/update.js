// (1) 회원정보 수정
function update(userId, event) {
    event.preventDefault();

    let data = $("#profileUpdate").serialize();

    $.ajax({
        type: "put",
        data: data,
        url: `/api/user/${userId}`,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json"

    }).done(res => {
        console.log(res, "성공");
        location.href = `/user/${userId}`;

    }).fail(error => {
        if (error.data == null) {
            alert(error.responseJSON.message);
        } else {
            alert(JSON.stringify(error.responseJSON.data));
        }



    });
}