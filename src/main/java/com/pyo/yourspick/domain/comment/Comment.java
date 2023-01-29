package com.pyo.yourspick.domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(length = 100 , nullable = false)
    private String content;

    @JsonIgnoreProperties({"images"})
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image image;

    private LocalDate createDate;


    @PrePersist
    public void createDate(){
        this.createDate = LocalDate.now();
    }



}
