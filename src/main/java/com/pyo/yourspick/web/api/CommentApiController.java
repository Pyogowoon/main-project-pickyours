package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.comment.Comment;
import com.pyo.yourspick.handler.ex.CustomValidationApiException;
import com.pyo.yourspick.service.CommentService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.comment.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CommentApiController {


    private final CommentService commentService;

    @PostMapping("/api/comment")
    public ResponseEntity<?> commentSave(@Valid @RequestBody CommentDto commentDto, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        /* 댓글 쓰기 로직 서비스 */
        Comment comment = commentService.댓글쓰기(commentDto.getImageId(), commentDto.getContent(), principalDetails.getUser().getId());

        /* 댓글 쓰기 완료 HttpStatus 리턴 */
        return new ResponseEntity<>(new CMRespDto<>(1, "댓글쓰기 완료", comment), HttpStatus.CREATED);

    }

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<?> commentDelete(@PathVariable int id) {
        commentService.댓글삭제(id);

        return new ResponseEntity<>(new CMRespDto<>(1, "댓글삭제 완료", null), HttpStatus.OK);
    }
}
