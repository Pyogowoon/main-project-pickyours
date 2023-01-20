package com.pyo.yourspick.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/post/postview")
    public String post() {
        return "post/postview";
    }

    @GetMapping("/post/post")
    public String postview() {
        return "post/post";
    }

    @GetMapping("/image/upload")
    public String upload() {
        return "image/upload";
    }

    @GetMapping("/image/popular")
    public String popular() {
        return "image/popular";
    }




}
