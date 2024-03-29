<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/postheader.jsp" %>


   <form method="post" id="postSave" enctype="multipart/form-data" >

    <div class="container">

          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" name="title" placeholder="Enter title" id="title" required>
          </div>

         <div class="form-group">
           <label for="content">내용</label>
           <textarea class="form-control summernote" name="content" rows="5" id="content" required></textarea>
         </div>

         <div class="form-group">
            <label for="content"> 옷 상세정보 </label>
            <input type="text" class="form-control" name="entryTitle" placeholder="Enter title" id="entryTitle" required>
          </div>

        <div class="form-group">
              <label for="content"> 쇼핑몰 정보(링크와 설명) </label>
              <textarea class="form-control summernote" name="entryContent" rows="1" placeholder="Enter info" id="entryContent" required></textarea>
            </div>

         <div class="form-group">
            <label for="content"> 배우 이름 </label>
            <input type="text" class="form-control" name="actor" placeholder="Enter title" id="actor" required>
          </div>


        <div class="form-group">
          <label for="content"> 배우의 instagram 링크 </label>
          <input type="text" class="form-control" name="job" placeholder="Enter title" id="job" required>
        </div>

      <div class="form-group">
            <label for="content"> 키 </label>
            <input type="text" class="form-control" name="height" placeholder="Enter title" id="height" required>
          </div>

      <div class="form-group">
          <label for="content"> 몸무게 </label>
          <input type="text" class="form-control" name="weight" placeholder="Enter title" id="weight" required>
        </div>

        <div class="form-group">
      <label for="content"> 배우 사진 (최대 20MB까지 가능합니다.) </label>
      <input type="file" class="form-control" name="actorImage" id="actorImage" onchange="setThumbnail(event);"  accept=".jpg, .jpeg, .png, .tiff " required>
        <div id="imageContainer"></div>
        </div>


      <div class="form-group">
      <label for="content">옷 사진 (최대 20MB까지 가능합니다.) </label>
      <input type="file" class="form-control" name="clotheImage" id="clotheImage" onchange="setThumbnail2(event);" accept=".jpg, .jpeg, .png, .tiff " required>
        <div id="clothesContainer"></div>

    </div>

       <div class="form-group">
  <label for="content"> 동영상 (최대 20MB까지 가능합니다.) </label>
  <input type="file" class="form-control" name="video" id="video" onchange="setThumbnailVideo(event);" accept=".mp4, .wmv, .avi, .mov, .mpeg4" required>
            <div id="videoContainer"></div>
        </div>


        <input type="button" value="확인" onclick="postSave(${principal.user.id})" required>
        </form>
        <br/>
        <br/>



 </div>


        <!--

        -->





 <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>

<script src="/js/post/postsave.js"></script>
 <script src="/js/post/bootstrap.js"></script>
       <script src="/js/post/bootstrapbundle.js"></script>
         <script src="/js/post/popper.js"></script>
           <script src="/js/post/fontawesome.js"></script>
              <script src="/js/post/summernote.js"></script>




