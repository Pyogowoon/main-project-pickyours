package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.user.Role;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);


        if(user.getUsername().equals("admin")){
            user.setRole(Role.ADMIN);

        }else if(user.getUsername().equals("superadmin")){
            user.setRole(Role.SUPERADMIN);

        }else {
            user.setRole(Role.USER);
        }


        userRepository.save(user);



    }
}
