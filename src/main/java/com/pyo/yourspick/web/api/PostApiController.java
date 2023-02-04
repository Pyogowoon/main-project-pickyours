package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.PostService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;


    @PostMapping("/api/post/postsave")
    public ResponseEntity<?> postSave(PostDto postDto, @AuthenticationPrincipal  PrincipalDetails principalDetails) {

        System.out.println(postDto);

        MultipartFile clotheImage = postDto.getClotheImage();
        MultipartFile actorImage = postDto.getActorImage();
        MultipartFile video = postDto.getVideo();

      postService.게시글저장(postDto, principalDetails, clotheImage,actorImage,video);

      return new ResponseEntity<>(new CMRespDto<>(1, " 게시글 저장 실패", null), HttpStatus.OK);

    }

    @PostMapping("/api/post/likes/{postId}")
    public ResponseEntity<?> postLikes(@PathVariable int postId, @AuthenticationPrincipal PrincipalDetails principalDetails){
            System.out.println("컨트롤러 도달");
            System.out.println(postId);
            postService.좋아요하기(postId,principalDetails.getUser().getId());

        return new ResponseEntity<>(new CMRespDto<>(1,"좋아요 성공", null),HttpStatus.OK);
    }
    @DeleteMapping("/api/post/likes/{postId}")
    public ResponseEntity<?> postUnLikes(@PathVariable int postId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        postService.좋아요취소하기(postId, principalDetails.getUser().getId());

        return new ResponseEntity<>(new CMRespDto<>(1,"좋아요취소 성공", null),HttpStatus.OK);
    }


}
