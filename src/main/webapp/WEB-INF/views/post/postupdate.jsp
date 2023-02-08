<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/postheader.jsp" %>


   <form method="post" id="postUpdate" enctype="multipart/form-data" >

    <div class="container">

          <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" name="title" placeholder="Enter title" id="title" value="${post.title}">
          </div>

         <div class="form-group">
           <label for="content">content</label>
           <textarea class="form-control summernote" name="content" rows="5" id="content" >${post.content}</textarea>
         </div>

         <div class="form-group">
            <label for="content">entrytitle : 소제목 </label>
            <input type="text" class="form-control" name="entryTitle" placeholder="Enter title" id="entryTitle" value="${post.entryTitle}">
          </div>

        <div class="form-group">
              <label for="content">entryContent : 소본문 </label>
              <textarea class="form-control summernote" name="entryContent" rows="1" id="entryContent">${post.entryContent}</textarea>
            </div>

         <div class="form-group">
            <label for="content">actor : 배우 </label>
            <input type="text" class="form-control" name="actor" placeholder="Enter title" id="actor" value="${post.actor}">
          </div>


        <div class="form-group">
          <label for="content">job : 직업 </label>
          <input type="text" class="form-control" name="job" placeholder="Enter title" id="job" value="${post.job}">
        </div>

      <div class="form-group">
            <label for="content">height : 키 </label>
            <input type="text" class="form-control" name="height" placeholder="Enter title" id="height" value="${post.title}">
          </div>

      <div class="form-group">
          <label for="content">weight : 몸무게 </label>
          <input type="text" class="form-control" name="weight" placeholder="Enter title" id="weight" value="${post.weight}">
        </div>

        <div class="form-group">
      <label for="content">actorImage : 소본문(배우or드라마 사진) </label>
      <input type="file" class="form-control" name="actorImage" id="actorImage" value="${post.postImageUrlLeft}">
        </div>


      <div class="form-group">
      <label for="content">clotheImage : 소본문(옷 사진) </label>
      <input type="file" class="form-control" name="clotheImage" id="clotheImage" value="${post.postImageUrlRight}" >
    </div>

       <div class="form-group">
  <label for="content">video : 영상 </label>
  <input type="file" class="form-control" name="video" id="video" value="${post.postVideoUrl}" >
   <input type="hidden" class="form-control"  value="${post.postVideoUrl}">
        </div>


        <input type="button" value="확인" onclick="postUpdate(${post.id})">
        </form>



 </div>






 <script>

      $('.summernote').summernote({

        tabsize: 2,
        height: 300
      });
    </script>

<script src="/js/post/postupdate.js"></script>




