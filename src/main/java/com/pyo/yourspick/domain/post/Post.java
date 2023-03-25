package com.pyo.yourspick.domain.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.postlikes.PostLikes;
import com.pyo.yourspick.domain.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @NotNull
    @Column(length = 100)
    private String title;

    @Lob
    @NotNull
    @Column(length = 1000)
    private String content;

    @NotNull
    @Column(length = 100)
    private String entryTitle;

    @NotNull
    @Column(length = 1000)
    private String entryContent;

    @NotNull
    private String actor;
    @NotNull
    private String job;
    @NotNull
    private String height;
    @NotNull
    private String weight;

    @JsonIgnoreProperties({"images"})
    @JoinColumn(name="userId")
    @ManyToOne
    private User user;

    @NotNull
    private String postImageUrlLeft;
    @NotNull
    private String postImageUrlRight;
    @NotNull
    private String postVideoUrl;

    private String createDate;


    @OrderBy("id DESC")
    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<PostComment> postComment;

    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post",  orphanRemoval = true)
    private List<PostLikes> postLikes;


    @Transient
    private int likeState;

    @Transient
    private int likeUser;


    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void update(User user, String title, String content, String entryTitle, String entryContent
            , String actor, String job, String height, String weight) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.entryTitle = entryTitle;
        this.entryContent = entryContent;
        this.actor = actor;
        this.job = job;
        this.height = height;
        this.weight = weight;

    }
    public void leftImageUpdate(String postImageUrlLeft){
        this.postImageUrlLeft = postImageUrlLeft;

    }
    public void rightImageUpdate(String postImageUrlRight){
        this.postImageUrlRight = postImageUrlRight;

    }
    public void videoUpdate(String postVideoUrl){
        this.postVideoUrl = postVideoUrl;
    }

    public void commentId (int id){
        this.id = id;

    }


}
