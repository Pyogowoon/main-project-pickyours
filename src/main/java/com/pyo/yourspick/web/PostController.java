package com.pyo.yourspick.web;


import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.post.PostRepository;
import com.pyo.yourspick.service.PostService;
import com.pyo.yourspick.web.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;


    @GetMapping("/post/postview/{id}")
    public String postview(@PathVariable int id, Model model) {
        model.addAttribute(postService.포스트상세보기(id));
        return "post/postview";
    }

    @GetMapping("/post/post")
    public String post(Model model ,  @PageableDefault(size=7, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {

  model.addAttribute("post", postService.포스트로드(pageable));

        return "post/post";
    }

    @GetMapping("/post/postsave")
    public String postsave(){

        return "post/postsave";
    }

    @GetMapping("/post/pagintest")
    public Page<Post> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Post> pagingPost = postRepository.findAll(pageable);

        return pagingPost;
    }

}
