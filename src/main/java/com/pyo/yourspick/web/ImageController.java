package com.pyo.yourspick.web;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.service.ImageService;
import com.pyo.yourspick.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;


    @GetMapping("/")
    public String index() {
        return "index";
    }



    @GetMapping("/image/upload")
    public String upload() {
        return "image/upload";
    }

    @GetMapping("/image/popular")
    public String popular(Model model) {

        List<Image> images = imageService.인기사진();
        model.addAttribute("images", images);


        return "image/popular";
    }


    @PostMapping("/image")
    public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails){


        if(imageUploadDto.getFile().isEmpty()){
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null );
        }else{
            imageService.이미지업로드(imageUploadDto , principalDetails);
            return "redirect:/user/"+principalDetails.getUser().getId();
        }
    }


}
