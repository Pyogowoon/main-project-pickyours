package com.pyo.yourspick.web;

import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.UserService;
import com.pyo.yourspick.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController{

   private final UserService userService;

    @GetMapping("user/board")
    public String board(){


        return "user/board";
    }

    @GetMapping("user/{pageUserId}")
    public String profile(@PathVariable int pageUserId, Model model,@AuthenticationPrincipal PrincipalDetails principalDetails){
        UserProfileDto dto = userService.회원프로필(pageUserId,principalDetails.getUser().getId());

        model.addAttribute("dto", dto);


        return "user/profile";
    }

    @GetMapping("user/{id}/update")
    public String update(@PathVariable int id , @AuthenticationPrincipal PrincipalDetails principalDetails){


        return "user/update";
    }
}
