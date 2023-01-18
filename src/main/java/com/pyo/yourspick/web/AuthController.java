package com.pyo.yourspick.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/auth/signin")
    public String signin(){

        return "auth/signin";
    }
    @GetMapping("/auth/join")
    public String join(){

        return "auth/join";
    }

    @GetMapping("/board/board")
    public String board(){

        return "board/board";
    }

    @GetMapping("/board/post")
    public String post(){

        return "board/post";
    }
}
