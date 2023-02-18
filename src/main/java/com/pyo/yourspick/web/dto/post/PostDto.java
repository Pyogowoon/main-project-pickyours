package com.pyo.yourspick.web.dto.post;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {

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


    private MultipartFile actorImage;

    private MultipartFile clotheImage;

    private MultipartFile video;

    public Post toEntity(User user, String actorImage , String clotheImage , String video){
        return Post.builder()
                .title(title)
                .content(content)
                .entryTitle(entryTitle)
                .entryContent(entryContent)
                .actor(actor)
                .job(job)
                .height(height)
                .weight(weight)
                .user(user)
                .postImageUrlLeft(actorImage)
                .postImageUrlRight(clotheImage)
                .postVideoUrl(video)

                .build();
    }
}
