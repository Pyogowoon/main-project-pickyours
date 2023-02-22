package com.pyo.yourspick.domain.postcomment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PostComment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(length = 100 , nullable = false)
    private String content;

    private String commentUser;


    @JsonIgnoreProperties({"posts"})
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    @JsonIgnoreProperties({"postComment"})
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    private String createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void CommentSave(User user, String content, Post post, String CommentUser){
        this.user = user;
        this.content = content;
        this.post = post;
        this.commentUser= commentUser;

    }

}

