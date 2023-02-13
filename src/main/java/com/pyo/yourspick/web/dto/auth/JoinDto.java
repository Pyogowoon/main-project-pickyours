package com.pyo.yourspick.web.dto.auth;


import com.pyo.yourspick.domain.user.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class JoinDto {

    @Size(min= 5 , max = 12,message = "크기가 5~12자 사이여야 합니다.")
    @NotBlank(message = "유저네임을 입력해주세요.")
    private String username;

    //@Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    @NotBlank(message = "이메일 주소를 입력해주세요.")
    private String email;

    @NotBlank
    private String name;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();



    }
}
