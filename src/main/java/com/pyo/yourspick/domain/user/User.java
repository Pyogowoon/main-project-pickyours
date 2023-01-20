package com.pyo.yourspick.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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


    private String role;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

}
