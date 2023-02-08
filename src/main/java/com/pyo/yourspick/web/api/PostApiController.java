package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.PostService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.post.PostDto;
import com.pyo.yourspick.web.dto.post.PostUpdateDto;
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

    Post post = postService.게시글저장(postDto, principalDetails, clotheImage,actorImage,video);

      return new ResponseEntity<>(new CMRespDto<>(1, " 게시글 저장 성공", post), HttpStatus.OK);

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

    @PutMapping("/api/post/postupdate/{postId}")
    public ResponseEntity<?> postUpdate(PostUpdateDto postUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails,
                                        @PathVariable int postId){
        System.out.println(postUpdateDto);
//        System.out.println("getActorImage : "+ postUpdateDto.getActorImage().getOriginalFilename());
//        System.out.println("getclotheImage : "+ postUpdateDto.getClotheImage().getName());
//        System.out.println("getvideo : "+ postUpdateDto.getVideo().getOriginalFilename());
       MultipartFile actorImage = postUpdateDto.getActorImage();
        MultipartFile clotheImage = postUpdateDto.getClotheImage();
        MultipartFile video = postUpdateDto.getVideo();


       Post postEntity = postService.게시글수정(postUpdateDto.toEntity(),actorImage,clotheImage,video,principalDetails,postId);

        return new ResponseEntity<>(new CMRespDto<>(1,"수정 성공",postEntity), HttpStatus.OK );
    }


}
