package com.pyo.yourspick.web.dto.post;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
