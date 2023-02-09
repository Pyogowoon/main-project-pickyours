package com.pyo.yourspick.domain.image;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.comment.Comment;
import com.pyo.yourspick.domain.likes.Likes;
import com.pyo.yourspick.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Image {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String caption;

    private String postImageUrl;


    @JsonIgnoreProperties({"images"})
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    @JsonIgnoreProperties({"image"})
    @OneToMany(mappedBy = "image", orphanRemoval = true)
    private List<Likes> likes;

    @OrderBy("id DESC")
    @JsonIgnoreProperties({"image"})
    @OneToMany(mappedBy = "image", orphanRemoval = true)
    private List<Comment> comments;


    @Transient
    private boolean likeState;

    @Transient
    private int likeCount;


    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
            this.createDate = LocalDateTime.now();
    }

}
