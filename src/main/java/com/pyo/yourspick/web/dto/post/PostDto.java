package com.pyo.yourspick.web.dto.post;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {

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

    /* 영상은 일단 보류 */
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
