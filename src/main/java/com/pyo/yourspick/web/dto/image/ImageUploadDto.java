package com.pyo.yourspick.web.dto.image;

import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.user.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ImageUploadDto {

    private MultipartFile file;
    private String caption;


    public Image toEntity(String postImageUrl, User user){
        return Image.builder()
                .postImageUrl(postImageUrl)
                .caption(caption)
                .user(user)
                .build();
    }
}
