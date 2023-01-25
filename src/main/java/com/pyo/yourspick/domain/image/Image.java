package com.pyo.yourspick.domain.image;


import com.pyo.yourspick.domain.user.User;
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
public class Image {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String caption;

    private String postImageUrl;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
            this.createDate = LocalDateTime.now();
    }

}
