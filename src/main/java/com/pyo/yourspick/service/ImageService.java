package com.pyo.yourspick.service;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.image.ImageRepository;
import com.pyo.yourspick.domain.subscribe.SubscribeRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.handler.ex.CustomException;
import com.pyo.yourspick.web.dto.image.ImageUploadDto;
import com.pyo.yourspick.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    private final UserRepository userRepository;

    private final SubscribeRepository subscribeRepository;

    @Value("${file.path}")
    private String uploadFolder;




    @Transactional(readOnly = true)
    public Page<Image> 유저마당메인(int principalId, Pageable pageable) {

        Page<Image> images = imageRepository.mStory(principalId, pageable);

        images.forEach((image) -> {

            image.setLikeCount(image.getLikes().size());

            image.getLikes().forEach((like) -> {
                if (like.getUser().getId() == principalId) {
                    image.setLikeState(true);
                }

            });

        });

        return images;
    }

    @Transactional(readOnly = true)
    public void 이미지업로드(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);


        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser());
        Image imageEntity = imageRepository.save(image);

    }

    @Transactional(readOnly = true)
    public List<Image> 인기사진() {

        return imageRepository.mPopular();


    }

    @Transactional
    public void 게시글삭제(int imageId) {
        imageRepository.deleteById(imageId);


    }

    @Transactional(readOnly = true)
    public UserProfileDto 게시글검색(String keyword, int userId) {
        if (keyword.isEmpty()) {
            throw new CustomException("검색어를 입력해주세요");
        }

        List<User> searchEntity = userRepository.mFindCaption(keyword);
        if (searchEntity == null || searchEntity.isEmpty()) {
            throw new CustomException("해당하는 유저가 없습니다.");
        }

        User userEntity = userRepository.findByName(keyword);


        UserProfileDto dto = new UserProfileDto();

        dto.setUser(userEntity);
        dto.setPageOwnerState(userEntity.getId() == userId);
        dto.setImageCount(userEntity.getImages().size());

        int subscribeState = subscribeRepository.mSubscribeState(userId, userEntity.getId());
        int subscribeCount = subscribeRepository.mSubscribeCount(userEntity.getId());

        dto.setSubscribeState(subscribeState == 1);
        dto.setSubscribeCount(subscribeCount);

        userEntity.getImages().forEach((image) -> {
            image.setLikeCount(image.getLikes().size());
        });


        return dto;


//
//
//
//       int keywordId = searchEntity.get(0).getId();
//        Image images =imageRepository.findById(keywordId).orElseThrow(()->{
//            throw new CustomException("해당 유저는 찾을 수 없습니다.");
//        });
//
//
//
//       return images;
    }

}
