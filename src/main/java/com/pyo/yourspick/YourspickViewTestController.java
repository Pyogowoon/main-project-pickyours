package com.pyo.yourspick;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YourspickViewTestController {


    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/signin")
    public String 메인(){

        return "signin";
    }
}
