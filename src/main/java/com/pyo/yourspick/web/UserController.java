package com.pyo.yourspick.web;

import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.subscribe.SubscribeRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.service.ImageService;
import com.pyo.yourspick.service.SubscribeService;
import com.pyo.yourspick.service.UserService;
import com.pyo.yourspick.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController{

   private final UserService userService;

   private final SubscribeService subscribeService;

   private final SubscribeRepository subscribeRepository;

   private final ImageService imageService;

    @GetMapping("user/board")
    public String board(@AuthenticationPrincipal PrincipalDetails principalDetails , @PageableDefault(size=3) Pageable pageable,Model model){
        int userid = principalDetails.getUser().getId();

        int subscribeState = subscribeRepository.mSubscribeState(userid,1);
        if(subscribeState != 1){
            subscribeService.구독하기(userid, 1);
        }
      model.addAttribute("user",userService.유저이름사진정보찾기());

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
