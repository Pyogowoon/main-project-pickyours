package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.subscribe.SubscribeRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserInfoMapping;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.handler.ex.CustomException;
import com.pyo.yourspick.handler.ex.CustomValidationApiException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final SubscribeRepository subscribeRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${file.path}")
    private String uploadFolder;


    @Transactional
    public User 회원수정(int id, User user) {
        User userEntity = userRepository.findById(id).orElseThrow(() ->
        {
            throw new CustomValidationApiException("찾을 수 없는 아이디 입니다.");
        });


        if (user.getPassword().equals("")) {

            userEntity.setName(user.getName());
            userEntity.setWebsite(user.getWebsite());
            userEntity.setBio(user.getBio());
            userEntity.setPhone(user.getPhone());
            userEntity.setGender(user.getGender());

            return userEntity;
        } else {

            userEntity.setName(user.getName());


            String rawPassword = user.getPassword();
            String encPassword = bCryptPasswordEncoder.encode(rawPassword);

            userEntity.setPassword(encPassword);
            userEntity.setWebsite(user.getWebsite());
            userEntity.setBio(user.getBio());
            userEntity.setPhone(user.getPhone());
            userEntity.setGender(user.getGender());

            return userEntity;

        }


    }

    @Transactional(readOnly = true)
    public UserProfileDto 회원프로필(int pageUserId, int principalId) {

        UserProfileDto dto = new UserProfileDto();

        User userEntity = userRepository.findById(pageUserId).orElseThrow(() -> {
            throw new CustomException("해당 유저 프로필 페이지는 찾을 수 없습니다.");
        });

        dto.setUser(userEntity);
        dto.setPageOwnerState(pageUserId == principalId);
        dto.setImageCount(userEntity.getImages().size());

        int subscribeState = subscribeRepository.mSubscribeState(principalId, pageUserId);
        int subscribeCount = subscribeRepository.mSubscribeCount(pageUserId);

        dto.setSubscribeState(subscribeState == 1);
        dto.setSubscribeCount(subscribeCount);

        userEntity.getImages().forEach((image) -> {
            image.setLikeCount(image.getLikes().size());
        });

        return dto;

    }

    @Transactional
    public User 회원프로필사진변경(int principalId, MultipartFile profileImageFile) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + profileImageFile.getOriginalFilename();

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);


        try {
            Files.write(imageFilePath, profileImageFile.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        User userEntity = userRepository.findById(principalId).orElseThrow(() -> {
            throw new CustomApiException("유저를 찾을 수 없습니다.");
        });


        userEntity.setProfileImageUrl(imageFileName);
        return userEntity;
    }

    public List<UserInfoMapping> 유저이름사진정보찾기() {

        List<UserInfoMapping> user = userRepository.mFindUser();
        return user;
    }
}

