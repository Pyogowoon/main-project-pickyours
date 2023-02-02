package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.PostCommentService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.postcomment.PostCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostCommentApicontroller {

    private final PostCommentService postCommentService;



    @PostMapping("/api/post/comment")
    public ResponseEntity<?> postComment(@RequestBody PostCommentDto postCommentDto,
                                         @AuthenticationPrincipal PrincipalDetails principalDetails){


        System.out.println(postCommentDto);
        PostComment postComment = postCommentService.댓글달기(principalDetails.getUser().getId(),postCommentDto.getContent());

        return new ResponseEntity<>(new CMRespDto<>(1,"댓글쓰기 성공",postComment), HttpStatus.OK);

    }
}
