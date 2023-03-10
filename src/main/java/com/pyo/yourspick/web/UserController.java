package com.pyo.yourspick.web;

import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.likes.Likes;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.subscribe.SubscribeRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserInfoMapping;
import com.pyo.yourspick.service.ImageService;
import com.pyo.yourspick.service.LikesService;
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

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    private final SubscribeService subscribeService;

    private final SubscribeRepository subscribeRepository;

    private final ImageService imageService;


    @GetMapping("user/board")
    public String board(@AuthenticationPrincipal PrincipalDetails principalDetails, @PageableDefault(size = 3) Pageable pageable, Model model) {
        int userId = principalDetails.getUser().getId();

        int subscribeState = subscribeRepository.mSubscribeState(userId, 1);
        if (subscribeState != 1) {

            if (userId == 1) {

                subscribeService.구독하기(userId, userId);
            } else {
                subscribeService.구독하기(userId, 1);
                subscribeService.구독하기(userId, userId);
            }
        }
        List<UserInfoMapping> userFind = userService.유저이름사진정보찾기();
        Collections.shuffle(userFind);
        model.addAttribute("user", userFind);

        return "user/board";
    }

    @GetMapping("user/{pageUserId}")
    public String profile(@PathVariable int pageUserId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        UserProfileDto dto = userService.회원프로필(pageUserId, principalDetails.getUser().getId());

        model.addAttribute("dto", dto);


        return "user/profile";
    }

    @GetMapping("user/{id}/update")
    public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {


        return "user/update";
    }

    @GetMapping("user/board/{imageId}")
    public String boardView(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {

        Image imageEntity = userService.상세보기(imageId, principalDetails.getUser().getId());
        model.addAttribute("image", imageEntity);

        return "user/boardview";
    }

    @GetMapping("/user/board/search/name")
    public String boardSearch(String keyword, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {


        UserProfileDto dto = imageService.게시글검색(keyword, principalDetails.getUser().getId());


        model.addAttribute("dto", dto);

        model.addAttribute("keyword", keyword);

        return "user/boardsearch";
    }


}
