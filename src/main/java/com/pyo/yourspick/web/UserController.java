package com.pyo.yourspick.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController{

    @GetMapping("user/board")
    public String board(){


        return "user/board";
    }

    @GetMapping("user/{id}")
    public String profile(@PathVariable int id){


        return "user/profile";
    }

    @GetMapping("user/{id}/update")
    public String update(@PathVariable int id){


        return "user/update";
    }
}
