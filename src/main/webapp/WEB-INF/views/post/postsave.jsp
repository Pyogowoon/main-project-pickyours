<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/postheader.jsp" %>


   <form method="post" id="postSave" enctype="multipart/form-data" >

    <div class="container">

          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" name="title" placeholder="Enter title" id="title">
          </div>

         <div class="form-group">
           <label for="content">내용</label>
           <textarea class="form-control summernote" name="content" rows="5" id="content"></textarea>
         </div>

         <div class="form-group">
            <label for="content"> 소제목 </label>
            <input type="text" class="form-control" name="entryTitle" placeholder="Enter title" id="entryTitle">
          </div>

        <div class="form-group">
              <label for="content"> 쇼핑몰 정보(링크와 설명) </label>
              <textarea class="form-control summernote" name="entryContent" rows="1" id="entryContent"></textarea>
            </div>

         <div class="form-group">
            <label for="content"> 배우 이름 </label>
            <input type="text" class="form-control" name="actor" placeholder="Enter title" id="actor">
          </div>


        <div class="form-group">
          <label for="content"> 배우의 instagram 링크 </label>
          <input type="text" class="form-control" name="job" placeholder="Enter title" id="job">
        </div>

      <div class="form-group">
            <label for="content"> 키 </label>
            <input type="text" class="form-control" name="height" placeholder="Enter title" id="height">
          </div>

      <div class="form-group">
          <label for="content"> 몸무게 </label>
          <input type="text" class="form-control" name="weight" placeholder="Enter title" id="weight">
        </div>

        <div class="form-group">
      <label for="content"> 배우 사진 </label>
      <input type="file" class="form-control" name="actorImage" id="actorImage">
        </div>


      <div class="form-group">
      <label for="content">옷 사진 </label>
      <input type="file" class="form-control" name="clotheImage" id="clotheImage">
    </div>

       <div class="form-group">
  <label for="content">video : 영상 </label>
  <input type="file" class="form-control" name="video" id="video">
        </div>


        <input type="button" value="확인" onclick="postSave(${principal.user.id})">
        </form>



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




