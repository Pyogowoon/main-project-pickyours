package com.pyo.yourspick.web.dto.post;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PostUpdateDto {

    private User user;

    private String title;

    private String content;

    private String entryTitle;

    private String entryContent;

    private String actor;

    private String job;

    private String height;

    private String weight;



    private MultipartFile actorImage;

    private MultipartFile clotheImage;

    private MultipartFile video;




    }
