<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/postheader.jsp" %>


   <form method="post" id="postUpdate" enctype="multipart/form-data" >

    <div class="container">

          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" name="title" placeholder="Enter title" id="title" value="${post.title}">
          </div>

         <div class="form-group">
           <label for="content">내용</label>
           <textarea class="form-control summernote" name="content" rows="5" id="content" value="${post.content}">${post.content}</textarea>
         </div>

         <div class="form-group">
            <label for="entryTitle">옷 상세정보 </label>
            <input type="text" class="form-control" name="entryTitle" placeholder="Enter title" id="entryTitle" value="${post.entryTitle}">
          </div>

        <div class="form-group">
              <label for="content">쇼핑몰 정보(링크와 설명) </label>
              <textarea class="form-control summernote" name="entryContent" rows="1" id="entryContent" value="${post.entryContent}">${post.entryContent}</textarea>
            </div>

         <div class="form-group">
            <label for="content">배우 이름 </label>
            <input type="text" class="form-control" name="actor" placeholder="Enter title" id="actor" value="${post.actor}" size="6">
          </div>


        <div class="form-group">
          <label for="content">배우의 인스타그램 링크 </label>
          <input type="text" class="form-control" name="job" placeholder="Enter title" id="job" value="${post.job}">
        </div>

      <div class="form-group">
            <label for="content"> 키 </label>
            <input type="text" class="form-control" name="height" placeholder="Enter title" id="height" value="${post.title}">
          </div>

      <div class="form-group">
          <label for="content"> 몸무게 </label>
          <input type="text" class="form-control" name="weight" placeholder="Enter title" id="weight" value="${post.weight}">
        </div>

        <div class="form-group">
      <label for="content"> 배우 사진 (최대 20MB까지 가능합니다.)</label>
      <input type="file" class="form-control" name="actorImage" id="actorImage" >
        </div>


      <div class="form-group">
      <label for="content">옷 사진 (최대 20MB까지 가능합니다.) </label>
      <input type="file" class="form-control" name="clotheImage" id="clotheImage" >
    </div>

       <div class="form-group">
  <label for="content"> 동영상 (최대 20MB까지 가능합니다.) </label>
  <input type="file" class="form-control" name="video" id="video"  >
   <input type="hidden" class="form-control" >
        </div>


        <input type="button" value="확인" onclick="postUpdate(${post.id})">
        </form>
        <br/>
        <br/>



 </div>


 <script>

      $('.summernote').summernote({

        tabsize: 2,
        height: 300
      });
    </script>

<script src="/js/post/postupdate.js"></script>




