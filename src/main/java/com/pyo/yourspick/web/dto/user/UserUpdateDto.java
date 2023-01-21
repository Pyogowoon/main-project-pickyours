package com.pyo.yourspick.web.dto.user;


import com.pyo.yourspick.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private String website;

    private String bio;

    private String phone;

    private String gender;


    public User toEntity(){
            return User.builder()
                    .name(name)
                    .password(password)
                    .website(website)
                    .bio(bio)
                    .phone(phone)
                    .gender(gender)
                    .build();

    }

}
