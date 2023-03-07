# main-project-pickyours 

<br/>
  
### 의류 정보 및 유저 소셜서비스를 통합한 개인 프로젝트 입니다.
 ## 23.02.27 Update - 이제 Https 로 접속 가능합니다.
## <https://www.pickyours.co.kr>

게시글 저장과 모든 수정/삭제 기능을 사용하기 위해선 ADMIN 계정이 필요합니다.

임시 ID    :  admin

임시 Pwd : 관리자12!
 
 계정을 사용해주세요. 감사합니다.
##
<br/>



## Contacts

 이메일 주소
 
 sh5814367@gmail.com
 
 H.P.
 
 010 - 2217 - 4367
 
 BLOG
 
 <https://pyogowoon.tistory.com/>
 
 GITHUB
 
 <https://github.com/pyogowoon>
 
 
##

## 개요

- 프로젝트 명칭 : Pickyours 

- 개발 기간 :  2023 01.02 ~ 2023 02.23 

- 개인 프로젝트 

- 서비스 간단 소개 :  

 이 서비스의 주요 기능은 블로그 + 소셜 서비스 입니다.
 사용자는 원하는 정보를 블로그 시스템을 통해 간편히 찾을 수 있고, 소셜 서비스를 통하여 상호간의 소통으로도
 원하는 정보를 찾을 수 있습니다.
- 주요 기능 : 

  * 유저마당 : CRUD 기능, 스크롤 페이징 전략, 검색기능, 구독ㆍ좋아요ㆍ댓글 등 간단한 소셜 서비스
  
  * 게시글 : CRUD 기능, 페이징, 검색기능, 좋아요ㆍ댓글, 업로드 기능
  
  * 사용자 : Security 회원가입 및 로그인 , OAuth2.0 네이버, 카카오 로그인, 회원 정보 수정 
  
  * 유효성 검사 : AOP 처리
 
 
<br/>
<br/>

## 2. 사용 기술
 ` Back-end `
 
- JAVA 11 
 
 
- Spring Boot 2.7.7 
 
 
- Gradle 7.6 

 
- Spring Security 

 
- Spring Data JPA 

 
- Oauth 2.0 
<br/>
 
 ` Front-end 
 `
 - Bootstrap 4
 
 - Javascript es6
 
 - jQuery 
  
<br/>

` Database `

- H2 

- MariaDB 

<br/>

` DevOps `

 - AWS
 
 - Linux
 
 ## 3. DB 설계 
 <details>
     <summary> <h3> ERD 이미지 펼치기 </h3> </summary>
 
 <img src="./src/main/resources/static/images/ERD.png">
 
 </details>
 
 
  <details>
     <summary> <h3> DB 구성 펼치기 </h3> </summary>
 
 <img src="./src/main/resources/static/images/readme/DB_User.png">
 
 <img src="./src/main/resources/static/images/readme/DB_User_Image.png">
 
 <img src="./src/main/resources/static/images/readme/DB_User_Comment.png">
 
 <img src="./src/main/resources/static/images/readme/DB_User_Likes.png">
 
 <img src="./src/main/resources/static/images/readme/DB_User_Subscribe.png">
 
 
 
 <img src="./src/main/resources/static/images/readme/DB_Post.png">
 
 <img src="./src/main/resources/static/images/readme/DB_Post_PostLikes.png">
 
 
 <img src="./src/main/resources/static/images/readme/DB_Post_PostComment.png">
 

 
 </details>
 
 
 
 
 ## 4. API 설계
 <details>
 <summary> <h3> API 설계 펼치기 </h3> </summary>
 
 <img src="./src/main/resources/static/images/readme/User_API.png">
 
 <img src="./src/main/resources/static/images/readme/Blog_API.png">
  
 <img src="./src/main/resources/static/images/readme/Login_API.png">
   
 <img src="./src/main/resources/static/images/readme/Subscribe_API.png">
    
 <img src="./src/main/resources/static/images/readme/Likes_API.png">
 
 </details>
 
 ## 5. 기능 하이라이트
 
<details>
 <summary> <H2>블로그 포스팅 </h2></summary> 

<!-- summary 아래 한칸 공백 두어야함 -->
## 1. 멀티파츠 첨부기능
블로그 포스팅 서비스에서 가장 중요한 부분인 멀티파츠 저장 기능입니다.
이 기능을 만들기 위해 크게 2가지를 고려했습니다. 
 - text + textarea + file 타입,  다중타입 을 Ajax를 통해 보낼것. 
 - file 타입을 총 3가지 ( 사진, 사진, 동영상) 보내야하기 때문에 용량이 많이 발생할것이므로 외부에 업로드 폴더를 둬야했습니다. 
 
 -첫번째로 ajax 입니다.    [코드링크 : postsave.js](https://github.com/Pyogowoon/main-project-pickyours/blob/master/src/main/resources/static/js/post/postsave.js)
 
 ```javascript
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
```
 다중타입으로 보내기 위해 formdata 객체에 담아 데이터를 전송했고
  실패시 alert를 이용하여 에러 발생시 알림을 리턴합니다.
  <br/>
  <br/>
  
  그 후 2번째 조건인 외부 폴더에 파일을 업로드 하기위해 
  yml에 외부 폴더 경로를 적어준 후 Configuration 어노테이션을 사용하여
   빈을 수동으로 등록.
  
  ```java

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /* yml에 적힌 경로 */
    @Value("${file.path}")
    private String uploadFolder;

    /* 파일 업로드 핸들러 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry
                .addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + uploadFolder)
                .setCachePeriod(60*10*6) // 1시간동안 캐싱
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}
}  
  ```
  
 - 그 후 PostDto 로 데이터 받아와서 Service 단으로 넘김. [코드링크 : PostService ](https://github.com/Pyogowoon/main-project-pickyours/blob/master/src/main/java/com/pyo/yourspick/service/PostService.java)
   
   
   - DB에 저장 될 파일의 URL 이 중복되는것을 방지하기 위해 UUID값을 부여해주었고
    빈으로 등록한 경로를 찾고 Byte화 해서 저장하였습니다.
  
  ```java
   @Value("${file.path}")
    private String uploadFolder;

    /* 게시글 저장 */
    @Transactional
    public Post 게시글저장(PostDto postDto, PrincipalDetails principalDetails
            , MultipartFile clotheImage, MultipartFile actorImage, MultipartFile video) {

        /* 중복 방지용 임의 값 부여 */
        UUID uuid = UUID.randomUUID();
        String actorImageFileName = uuid + "_" + actorImage.getOriginalFilename();
        String clotheImageFileName = uuid + "_" + clotheImage.getOriginalFilename();
        String videoFileName = uuid + "_" + video.getOriginalFilename();

        /* 파일의 경로 찾기 */
        Path actorImageFilePath = Paths.get(uploadFolder + actorImageFileName);
        Path clotheImageFilePath = Paths.get(uploadFolder + clotheImageFileName);
        Path videoFilePath = Paths.get(uploadFolder + videoFileName);

        /* 지정한 경로에 Byte화 해서 저장 */
        try {
            Files.write(actorImageFilePath, actorImage.getBytes());
            Files.write(clotheImageFilePath, clotheImage.getBytes());
            Files.write(videoFilePath, video.getBytes());
        } catch (Exception e) {
            e.printStackTrace();

        }
        /* Builder 패턴 실행 */
        User user = principalDetails.getUser();
        Post post = postDto.toEntity(user, actorImageFileName, clotheImageFileName, videoFileName);

        return postRepository.save(post);

    }
  ```
  
  ## 2. 멀티파츠 수정기능
   두번째로 중요하다고 생각한 로직인 멀티파츠 수정 기능입니다.
  멀티파츠 수정기능을 구현하면서 리팩터링 고민에 빠지게되었습니다.
   수정기능은 2가지의 조건을 고려하면서 기능을 구현했습니다.
   
   - JPA 고유의 업데이트 방식인 Dirty Checking 을 활용하고자 했습니다.
   - Entity에 직접적으로 Setter를 사용하지 말아보기
  
 
 
 
 

</details>

<details>
 <summary> <h2> 소셜 서비스 </h2> </summary>
 
 
 내용
 </details>
  
  <details>
 <summary> <h2> 유효성 검사 </h2> </summary>
 
 
 내용
 </details>
  
  
 
 ## 6. Refactoring
 
 <br/>
 6-1 domain 의 Setter 사용 줄이기
  JPA 의 더티체킹을 이용한 Update 방식에서 Setter를 사용하지 않는 방법을 모색 -> 메서드를 사용
 

 ## 7. Troubleshooting
 <br/>
 
 ## 8. 향후 개선 방안
 
  DB 테이블 설계에서 FK 사용이 너무 잦음 - > JOIN 키로 바꿀 수 있도록
  DTO의 Response , Request 분리 필요 -> dto 정적팩토리 메소드를 쓸건지 Entity에 메서드를 만들것인지?
  
  
 
