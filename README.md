# main-project-pickyours 

<br/>
  
### 의류 정보 및 유저 소셜서비스를 통합한 개인 프로젝트 입니다.
 ## 23.02.27 Update - 이제 Https 로 접속 가능합니다.
## <https://www.pickyours.co.kr>

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

## 1. 제작기간 & 참여인원
<li> 2023 01.02 ~ 2023 02.23 </li>
<li> 개인 프로젝트 </li>
<br/>
<br/>

## 2. 사용 기술
 ` Back-end `
 
<li> JAVA 11 </li>
 
 
<li> Spring Boot 2.7.7 </li>
 
 
<li> Gradle 7.6 </li>

 
<li> Spring Security </li>

 
<li> Spring Data JPA </li>

 
<li> Oauth 2.0 </li>
<br/>
 
 ` Front-end 
 `
 <li> Bootstrap 4 </li>
 <li> Javascript es6 </li>
 <li> jQuery </li>
  
<br/>

` Database `
<li> H2 </li>
<li> MariaDB </li>

<br/>

` DevOps `
 <li> AWS</li>
 <li>Linux</li>
 
 ## 3. ERD 설계 
 <details>
 <summary> <h3> ERD 이미지 펼치기 </h3> </summary>
 
 <img src="./src/main/resources/static/images/ERD.png">
 
 </details>
 
 ## 4. API 설계
 <details>
 <summary> <h3> API 설계 펼치기 </h3> </summary>
 
 </details>
 
 ## 5. 주요 기능
 
 이 서비스의 주요 기능은 블로그 + 소셜 서비스 입니다.
 사용자는 원하는 정보를 블로그 시스템을 통해 간편히 찾을 수 있고, 소셜 서비스를 통하여 상호간의 소통으로
 원하는 정보를 찾을 수 있습니다.
 


<details>
 <summary> <H2>블로그 포스팅 </h2></summary> 

<!-- summary 아래 한칸 공백 두어야함 -->
## 접은 제목
접은 내용
</details>

<details>
 <summary> <h2> 소셜 서비스 </h2> </summary>
 
 
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
  
  
 
