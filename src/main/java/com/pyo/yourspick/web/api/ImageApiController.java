package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.service.ImageService;
import com.pyo.yourspick.service.LikesService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageApiController {

    private final ImageService imageService;
    private final LikesService likesService;


    /* 유저마당 메인페이지의 이미지 불러오기 요청 */
    @GetMapping("/api/image")
    public ResponseEntity<?> imageStory(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                        @PageableDefault(size = 3) Pageable pageable) {
        Page<Image> images = imageService.유저마당메인(principalDetails.getUser().getId(), pageable);

        return new ResponseEntity<>(new CMRespDto<>(1, "리스트 로딩 완료", images), HttpStatus.OK);
    }

    /* 유저마당의  좋아요 요청 */
    @PostMapping("/api/image/{imageId}/likes")
    public ResponseEntity<?> likes(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        likesService.좋아요(imageId, principalDetails.getUser().getId());
        return new ResponseEntity<>(new CMRespDto<>(1, "좋아요 성공", null), HttpStatus.OK);
    }

    /* 유저마당의 좋아요 취소 요청 */
    @DeleteMapping("/api/image/{imageId}/likes")
    public ResponseEntity<?> unLikes(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        likesService.좋아요취소(imageId, principalDetails.getUser().getId());
        return new ResponseEntity<>(new CMRespDto<>(1, "좋아요 취소성공", null), HttpStatus.OK);
    }


    /* 유저마당의 게시글 삭제 요청 */
    @DeleteMapping("/api/image/{imageId}")
    public ResponseEntity<?> storyContentDelete(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        imageService.게시글삭제(imageId);


        return new ResponseEntity<>(new CMRespDto<>(1, "삭제 성공", null), HttpStatus.OK);
    }

    /* 유저마당의 게시글 수정 요청 */
    @PutMapping("/api/image/{imageId}")
    public ResponseEntity<?> storyContentUpdate(ImageUploadDto imageUploadDto, @PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        imageService.게시글수정(imageUploadDto, imageId, principalDetails);

        return new ResponseEntity<>(new CMRespDto<>(1, "수정 성공", null), HttpStatus.OK);

    }


}
