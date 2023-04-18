package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.user.Role;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.handler.ex.CustomException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /* 회원 가입 로직 */
    @Transactional
    public void 회원가입(User user) {
        String username = user.getUsername();
        User userEntity = userRepository.findByUsername(username);
        User findName = userRepository.findByName(user.getName());

        /* 닉네임 존재하는지 확인 */
        if (findName != null) {

            throw new CustomValidationException("이미 존재하는 닉네임 입니다.", null);
        }

        /* 아이디 존재하는지 확인 */
        if (userEntity != null) {
            throw new CustomValidationException("이미 존재하는 아이디 입니다", null);
        } else {
            String rawPassword = user.getPassword();
            String encPassword = bCryptPasswordEncoder.encode(rawPassword);
            user.setPassword(encPassword);


            if (user.getUsername().equals("admin")) {
                user.setRole(Role.ADMIN);

            } else if (user.getUsername().equals("superadmin")) {
                user.setRole(Role.SUPERADMIN);

            } else {
                user.setRole(Role.USER);
            }


            userRepository.save(user);


        }

    }


}
