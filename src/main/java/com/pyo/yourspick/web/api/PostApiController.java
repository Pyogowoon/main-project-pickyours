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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/post/save")
    public String postSave(PostDto postDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
//        System.out.println(postDto);
//        System.out.println(id);
//        System.out.println(principalDetails.getUser().getRole());



        postService.게시글저장(postDto,principalDetails);



            return null;
//        return new ResponseEntity<>(new CMRespDto<>(1," 게시글 저장 실패" , null), HttpStatus.OK);
    }
}
