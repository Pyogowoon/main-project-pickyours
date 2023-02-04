package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.PostCommentService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.postcomment.PostCommentDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class PostCommentApicontroller {

    private final PostCommentService postCommentService;



    @PostMapping("/api/post/comment/{postId}")
    public ResponseEntity<?> postComment(@RequestBody PostCommentDto postCommentDto,
                                         @AuthenticationPrincipal PrincipalDetails principalDetails
    ,@PathVariable int postId){


        System.out.println(postCommentDto);
        PostComment postComment = postCommentService.댓글달기(principalDetails.getUser().getId(),postCommentDto.getContent(),postId);

        return new ResponseEntity<>(new CMRespDto<>(1,"댓글쓰기 성공",postComment), HttpStatus.OK);

    }
    @DeleteMapping("/api/post/comment/{commentId}")
    public ResponseEntity<?> postCommentDelete(@PathVariable int commentId){
        System.out.println("컨트롤러 도달");

        postCommentService.댓글삭제(commentId);

        return new ResponseEntity<>(new CMRespDto<>(1, "댓글 삭제 성공",null),HttpStatus.OK);
    }
}
