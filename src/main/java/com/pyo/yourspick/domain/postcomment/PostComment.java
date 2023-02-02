package com.pyo.yourspick.domain.postcomment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PostComment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String content;


    @JsonIgnoreProperties({"images"})
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonIgnoreProperties({"user"})
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    private String createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
