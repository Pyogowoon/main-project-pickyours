package com.pyo.yourspick.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.post.Post;
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
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(unique = true , length = 100)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String website;

    private String name;

    private String bio;

    private String gender;

    private String phone;

    private String profileImageUrl;

    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Image> images;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

}
