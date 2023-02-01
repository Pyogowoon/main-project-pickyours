package com.pyo.yourspick.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/post/postview")
    public String post() {
        return "post/postview";
    }

    @GetMapping("/post/post")
    public String postview() {
        return "post/post";
    }

    @GetMapping("/post/postsave")
    public String postsave(){

        return "post/postsave";
    }

}
