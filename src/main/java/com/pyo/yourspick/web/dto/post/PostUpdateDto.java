package com.pyo.yourspick.web.dto.post;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PostUpdateDto {
    @NotBlank
    private User user;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String entryTitle;
    @NotBlank
    private String entryContent;
    @NotBlank
    private String actor;
    @NotBlank
    private String job;
    @NotBlank
    private String height;
    @NotBlank
    private String weight;
    @NotBlank

    @NotNull
    private MultipartFile actorImage;
    @NotNull
    private MultipartFile clotheImage;
    @NotNull
    private MultipartFile video;


    public Post toEntity(){
        return Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .entryTitle(entryTitle)
                .entryContent(entryContent)
                .actor(actor)
                .job(job)
                .height(height)
                .weight(weight)
                .postImageUrlLeft(actorImage.toString())
                .postImageUrlRight(clotheImage.toString())
                .postVideoUrl(video.toString())
                .build();
    }

    }
