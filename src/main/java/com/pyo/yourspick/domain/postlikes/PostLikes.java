package com.pyo.yourspick.domain.postlikes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "postLikes_uk",
                        columnNames = {"postId", "userId"}

                )
        }
)
public class PostLikes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @JsonIgnoreProperties({"user"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    private LocalDateTime createDate;




    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();

    }

    @Override
    public String toString() {
        return "PostLikes{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                ", createDate=" + createDate +
                '}';
    }
}
