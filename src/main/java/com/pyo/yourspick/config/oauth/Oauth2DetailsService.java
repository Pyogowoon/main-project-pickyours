package com.pyo.yourspick.config.oauth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.user.Role;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class Oauth2DetailsService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);
        System.out.println("oauth2user 요청 : " + oauth2User.getAttributes());
        System.out.println("oauth2user 닉네임 : " + oauth2User.getAttributes().get("properties"));
        System.out.println("oauth2user 이메일 : " + oauth2User.getAttributes().get("email"));




        String provider = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("getRegistrationId 요청 : " + provider);

        /* kakao */
        if (provider.equals("kakao")) {
            System.out.println("카카오 요청");
            Map<String, Object> userKakaoInfo = oauth2User.getAttributes();

            String username = "Kakao_" + userKakaoInfo.get("id");
            String name = (String) userKakaoInfo.get("properties");
//            String email = (String) userKakaoInfo.get("email");
            String email = "vytjdgus1234@naver.com";
            String password = new BCryptPasswordEncoder().encode(UUID.randomUUID().toString());

            User userEntity = userRepository.findByUsername(username);

            if (userEntity == null) {
                User user = User.builder()
                        .username(username)
                        .name(name)
                        .email(email)
                        .password(password)
                        .role(String.valueOf(Role.USER)).

                        build();


                return new PrincipalDetails(userRepository.save(user), oauth2User.getAttributes());
            }else{
                return new PrincipalDetails(userEntity, oauth2User.getAttributes());
            }


            /* facebook */
        } else if (provider.equals("facebook")) {
            Map<String, Object> userInfo = oauth2User.getAttributes();
            String username = "Facebook_" + userInfo.get("id");
            String name = (String) userInfo.get("name");
            String email = (String) userInfo.get("email");
            String password = new BCryptPasswordEncoder().encode(UUID.randomUUID().toString());

            User userEntity = userRepository.findByUsername(username);

            if (userEntity == null) {

                User user = User.builder()
                        .username(username)
                        .password(password)
                        .email(email)
                        .name(name)
                        .role(String.valueOf(Role.USER))
                        .build();

                return new PrincipalDetails(userRepository.save(user), oauth2User.getAttributes());
            } else {
                return new PrincipalDetails(userEntity, oauth2User.getAttributes());
            }
            /* facebook End */
        } else {
            return null;
        }


    }


}
