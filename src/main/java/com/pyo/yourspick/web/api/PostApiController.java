package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.handler.ex.CustomException;
import com.pyo.yourspick.service.PostService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.post.PostDto;
import com.pyo.yourspick.web.dto.post.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;


    /* 게시글 불러오는 요청 */
    @GetMapping("/api/post")
    public ResponseEntity<?> post(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Post> post = postService.포스트로드(pageable);


        return new ResponseEntity<>(new CMRespDto<>(1, " 게시글 불러오기 성공", post), HttpStatus.OK);
    }

    /* 게시글 저장 요청 */
    @PostMapping("/api/post")
    public ResponseEntity<?> postSave(@Valid PostDto postDto, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails
    ) {

        /* 게시글 저장 시 인물사진 / 옷 사진 / 비디오 영상 이 하나라도 비어있을 경우 반환 로직 */
        if (postDto.getClotheImage().isEmpty() || postDto.getActorImage().isEmpty() || postDto.getVideo().isEmpty()) {
            return new ResponseEntity<>(new CMRespDto<>(-1, " 게시글 저장 실패", null), HttpStatus.BAD_REQUEST);

            /* 게시글 저장 시 요청사항 충족 시 */
        } else {

            MultipartFile clotheImage = postDto.getClotheImage();
            MultipartFile actorImage = postDto.getActorImage();
            MultipartFile video = postDto.getVideo();

            Post postEntity = postService.게시글저장(postDto, principalDetails, clotheImage, actorImage, video);

            return new ResponseEntity<>(new CMRespDto<>(1, " 게시글 저장 성공", null), HttpStatus.OK);

        }
    }

    /* 게시글 좋아요 요청 */
    @PostMapping("/api/post/{postId}/likes")
    public ResponseEntity<?> postLikes(@PathVariable int postId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        postService.좋아요하기(postId, principalDetails.getUser().getId());

        return new ResponseEntity<>(new CMRespDto<>(1, "좋아요 성공", null), HttpStatus.OK);
    }

    /* 게시글 좋아요 취소 요청 */
    @DeleteMapping("/api/post/{postId}/likes")
    public ResponseEntity<?> postUnLikes(@PathVariable int postId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        postService.좋아요취소하기(postId, principalDetails.getUser().getId());

        return new ResponseEntity<>(new CMRespDto<>(1, "좋아요취소 성공", null), HttpStatus.OK);
    }

    /* 게시글 수정 기능 */
    @PutMapping("/api/post/{postId}")
    public ResponseEntity<?> postUpdate(PostUpdateDto postUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails,
                                        @PathVariable int postId) {

        /* 멀티파트파일 getData 값 */
        MultipartFile actorImage = postUpdateDto.getActorImage();
        MultipartFile clotheImage = postUpdateDto.getClotheImage();
        MultipartFile video = postUpdateDto.getVideo();

        Post postEntity = postService.게시글수정(postUpdateDto, actorImage, clotheImage, video, principalDetails, postId);

        return new ResponseEntity<>(new CMRespDto<>(1, "수정 성공", postEntity), HttpStatus.OK);
    }

    /* 게시글 삭제 요청 */
    @DeleteMapping("/api/post/{postId}")
    public ResponseEntity<?> postDelete(@PathVariable int postId) {
        postService.게시글삭제(postId);

        return new ResponseEntity<>(new CMRespDto<>(1, "삭제 성공", null), HttpStatus.OK);
    }

}
