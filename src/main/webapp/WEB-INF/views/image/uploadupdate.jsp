<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ include file="../layout/userheader.jsp" %>

    <!--사진 업로드페이지 중앙배치-->
        <main class="uploadContainer">
         <div class="back" onclick="javascript:history.back()" ><img src="/images/left.png" style="height: 56px;width:56px"></div>
           <!--사진업로드 박스-->
            <section class="upload">
               
               <!--사진업로드 로고-->
                <div class="upload-top">

                        <img src="/images/logo.png" alt="">
                    </a>
                    <p>사진 업로드</p>
                </div>
                <!--사진업로드 로고 end-->
                
                <!--사진업로드 Form-->
                <form class="upload-form" id="imageUpdate" method="post" enctype="multipart/form-data">
                    <input  type="file" name="file"  onchange="imageChoose(this)"/>
                    <div class="upload-img">
                        <img src="/upload/${image.postImageUrl}" alt="" id="imageUploadPreview" />
                    </div>
                    
                    <!--사진설명 + 업로드버튼-->
                    <div class="upload-form-detail">
                   		 <input type="text" name="caption" value="${image.caption}">

                        <input type="button" class="cta blue" value="수정하기" style="width:340px;height:40px;" onclick="imageUpdate(${image.id})"/>
                    </div>
                    <!--사진설명end-->
                    
                </form>
                <!--사진업로드 Form-->
            </section>
            <!--사진업로드 박스 end-->
        </main>
        <br/><br/>
	
	<script src="/js/image/imageupdate.js" ></script>
