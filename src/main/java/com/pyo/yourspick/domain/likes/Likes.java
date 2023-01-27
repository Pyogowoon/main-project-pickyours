package com.pyo.yourspick.domain.likes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "likes_uk",
                        columnNames = {"imageId", "userId"}

                )
        }
)
public class Likes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image image;

    @JsonIgnoreProperties({"images"})
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private LocalDateTime createDate;


    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

}
