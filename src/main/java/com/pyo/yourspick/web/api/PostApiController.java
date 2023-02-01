package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.PostService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
        MultipartFile actorImage = postDto.getClotheImage();
        MultipartFile video = postDto.getVideo();
//        System.out.println(id);
//        System.out.println(principalDetails.getUser().getRole());
      postService.게시글저장(postDto, principalDetails, clotheImage,actorImage,video);

      return new ResponseEntity<>(new CMRespDto<>(1, " 게시글 저장 실패", null), HttpStatus.OK);

    }
}
    /*String fileName ="";

    Iterator<String> files = multi.getFileNames();
        while(files.hasNext()){
                String uploadFile = files.next();

                MultipartFile mFile = multi.getFile(uploadFile);
                fileName = mFile.getOriginalFilename();
                System.out.println("실제 파일 이름 : " + fileName);
                }*/