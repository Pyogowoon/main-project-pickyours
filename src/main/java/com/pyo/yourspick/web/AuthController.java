package com.pyo.yourspick.web;


import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.service.AuthService;
import com.pyo.yourspick.web.dto.auth.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;


    @GetMapping("/auth/signin")
    public String signin() {

        return "auth/signin";
    }


    @GetMapping("/auth/join")
    public String join() {

        return "auth/join";
    }

    @PostMapping("/auth/join")
    public String userJoin(@Valid JoinDto joinDto, BindingResult bindingResult) {

        User user = joinDto.toEntity();
        authService.회원가입(user);

        return "auth/signin";

    }


}



