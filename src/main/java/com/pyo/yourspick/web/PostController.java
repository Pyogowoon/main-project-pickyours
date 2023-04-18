package com.pyo.yourspick.web;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.post.PostRepository;
import com.pyo.yourspick.service.PostService;
import com.pyo.yourspick.web.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.JsonPath;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;


    /* 게시글 페이지 */
    @GetMapping("/post")
    public String post(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        model.addAttribute("post", postService.포스트로드(pageable));

        return "post/post";
    }


    /* 게시글 상세보기 페이지 */
    @GetMapping("/post/postview/{postId}")
    public String postview(@PathVariable int postId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("post", postService.포스트상세보기(postId));
        model.addAttribute("postComment", postService.댓글불러오기(postId));
        model.addAttribute("postLikes", postService.좋아요목록(principalDetails.getUser().getId(), postId));

        return "post/postview";
    }

    /* 게시글 저장 페이지 */
    @GetMapping("/post/postsave")
    public String postsave() {

        return "post/postsave";
    }

    /* 게시글 업데이트 페이지 */
    @GetMapping("/post/postupdate/{postId}")
    public String postUpdate(@PathVariable int postId, Model model) {
        model.addAttribute("post", postService.포스트상세보기(postId));

        return "post/postupdate";
    }


    /* 게시글 검색 페이지 */
    @GetMapping("/post/search/title")
    public String postSearch(String keyword, Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Post> postSearch = postService.게시글검색(keyword, pageable);

        model.addAttribute("postSearch", postSearch);
        model.addAttribute("keyword", keyword);
        return "/post/postsearch";
    }

}
