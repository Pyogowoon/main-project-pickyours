/**
     유저마당 프로필
  (1) 유저 프로파일 페이지 구독하기, 구독취소
  (2) 구독자 정보 모달 보기
  (3) 구독 정보 클릭시 나오는 모달
  (4) 유저 프로필 사진 변경
  (5) 사용자 정보 메뉴 열기 닫기
  (6) 사용자 정보(회원정보, 로그아웃, 닫기) 모달
  (7) 사용자 프로파일 이미지 메뉴(사진업로드, 취소) 모달
  (8) 구독자 정보 모달 닫기
 */

// (1) 유저 프로파일 페이지 구독하기, 구독취소
function toggleSubscribe(toUserId, obj) {
    if ($(obj).text() === "구독취소") {

        $.ajax({
            type: "delete",
            url: "/api/subscribe/" + toUserId,
            dataType: "json"

        }).done(res => {
            $(obj).text("구독하기");
            $(obj).toggleClass("blue");

        }).fail(error => {
            console.log("구독취소실패", error);
        });

    } else {

        $.ajax({
                type: "post",
                url: "/api/subscribe/" + toUserId,
                dataType: "json"
            }).done(res => {
                $(obj).text("구독취소");
                $(obj).toggleClass("blue");
            })
            .fail(error => {
                console.log("구독실패", error);
            });

    }
}

// (2) 구독자 정보  모달 보기
function subscribeInfoModalOpen(pageUserId) {
    $(".modal-subscribe").css("display", "flex");

    $.ajax({

        type: "get",
        url: `/api/user/${pageUserId}/subscribe`,
        dataType: "json"

    }).done(res => {

        res.data.forEach((u) => {
            let item = getSubscribeModalItem(u);
            $(".subscribe-list").append(item);
        });
    }).fail(error => {
        console.log("구독정보 불러오기 실패", error);
    });


}
//(3) 구독 정보 클릭시 나오는 모달
function getSubscribeModalItem(u) {
    let item = `
        <div class="subscribe__item" id="subscribeModalItem-${u.id}">
                <div class="subscribe__img">
                    <img src="/upload/${u.profileImageUrl}" onerror="this.src='/images/person.jpeg'"/>
                </div>
                <div class="subscribe__text">
                    <h2>${u.name}</h2>
                </div>
                <div class="subscribe__btn">`
    if (!u.equalUserState) {
        if (u.subscribeState) {
            item += `<button class="cta blue" onclick="toggleSubscribe(${u.id},this)">구독취소</button>`;
        } else {
            item += `<button class="cta" onclick="toggleSubscribe(${u.id},this)">구독하기</button>`;
        }
    }
    item += `

                </div>
            </div>`;


    return item;
}


// (4) 유저 프로필 사진 변경
function profileImageUpload(pageUserId, principalId) {
    $("#userProfileImageInput").click();


    if (pageUserId != principalId) {
        alert("계정의 주인만 바꿀 수 있습니다.");
        return;
    }

    $("#userProfileImageInput").on("change", (e) => {
        let f = e.target.files[0];

        if (!f.type.match("image.*")) {
            alert("이미지를 등록해야 합니다.");
            return;
        }

        let profileImageForm = $("#userProfileImageForm")[0];
        let formData = new FormData(profileImageForm);

        $.ajax({
            type: "put",
            url: `/api/user/${principalId}/profileImageUrl`,
            data: formData,
            contentType: false,
            processData: false,
            enctype: "multipart/form-data",
            dataType: "json"

        }).done(res => {
            let reader = new FileReader();
            /* 사진 업로드시 변경 로직 */
            reader.onload = (e) => {
                $("#userProfileImage").attr("src", e.target.result);
            }
            reader.readAsDataURL(f);
            /*                     */
        }).fail(error => {
            console.log("오류", error)

        });



    });
}


// (5) 사용자 정보 메뉴 열기 닫기
function popup(obj) {
    $(obj).css("display", "flex");
}

function closePopup(obj) {
    $(obj).css("display", "none");
}


// (6) 사용자 정보(회원정보, 로그아웃, 닫기) 모달
function modalInfo() {
    $(".modal-info").css("display", "none");
}

// (7) 사용자 프로파일 이미지 메뉴(사진업로드, 취소) 모달
function modalImage() {
    $(".modal-image").css("display", "none");
}

// (8) 구독자 정보 모달 닫기
function modalClose() {
    $(".modal-subscribe").css("display", "none");
    location.reload();
}