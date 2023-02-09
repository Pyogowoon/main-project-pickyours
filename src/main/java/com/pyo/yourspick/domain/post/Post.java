package com.pyo.yourspick.domain.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.postlikes.PostLikes;
import com.pyo.yourspick.domain.user.User;
import lombok.*;

import javax.persistence.*;
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

    @Column(length = 100)
    private String title;

    @Column(length = 1000)
    private String content;

    @Column(length = 100)
    private String entryTitle;

    @Column(length = 1000)
    private String entryContent;

    private String actor;

    private String job;

    private String height;

    private String weight;

    @JsonIgnoreProperties({"images"})
    @JoinColumn(name="userId")
    @ManyToOne
    private User user;


    private String postImageUrlLeft;

    private String postImageUrlRight;
    private String postVideoUrl;

    private String createDate;



    @OrderBy("id DESC")
    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post" , orphanRemoval = true )
    private List<PostComment> postComment;

    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post")
    private List<PostLikes> postLikes;


    @Transient
    private int likeState;

    @Transient
    private int likeUser;


    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }



}
