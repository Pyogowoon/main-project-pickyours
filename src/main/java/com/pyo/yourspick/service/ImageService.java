package com.pyo.yourspick.service;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.image.ImageRepository;
import com.pyo.yourspick.domain.subscribe.SubscribeRepository;
import com.pyo.yourspick.domain.user.Role;
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


    /* 유저마당 메인 페이지 읽어오는 로직 */
    @Transactional(readOnly = true)
    public Page<Image> 유저마당메인(int principalId, Pageable pageable) {

        Page<Image> images = imageRepository.mStory(principalId, pageable);

        /* forEach 문을 사용하여 좋아요 정보와 좋아요한 계정인지 확인하는 로직 */
        images.forEach((image) -> {

            /* 게시글의 좋아요 크기 판단 */
            image.setLikeCount(image.getLikes().size());

            /* 접속 유저에 대한 좋아요 상태 표시 */
            image.getLikes().forEach((like) -> {
                if (like.getUser().getId() == principalId) {
                    image.setLikeState(true);
                }

            });

        });

        return images;
    }

    /* 유저마당 이미지 업로드 로직 */
    @Transactional(readOnly = true)
    public void 이미지업로드(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {

        /* 중복 방지 차 파일의 이름 UUID */
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

    /* 인기사진 페이지 읽어오는 로직 */
    @Transactional(readOnly = true)
    public List<Image> 인기사진() {

        return imageRepository.mPopular();


    }

    /* 게시글 삭제 */
    @Transactional
    public void 게시글삭제(int imageId) {
        imageRepository.deleteById(imageId);


    }

    /* 유저 네임을 통한 유저의 프로필 검색*/
    @Transactional(readOnly = true)
    public UserProfileDto 게시글검색(String keyword, int userId) {

        /* 해당 유저 존재 유무 확인*/
        if (keyword.isEmpty()) {
            throw new CustomException("검색어를 입력해주세요");
        }

        List<User> searchEntity = userRepository.mFindCaption(keyword);
        if (searchEntity == null || searchEntity.isEmpty()) {
            throw new CustomException("해당하는 유저가 없습니다.");
        }

        User userEntity = userRepository.findByName(keyword);

        /* 검색된 유저 정보 ( 프로필 정보 ) */
        UserProfileDto dto = new UserProfileDto();

        /* 검색된 유저가 검색한 유저와 동일한지 확인 후 프로필 정보 불러오기*/
        dto.setUser(userEntity);
        dto.setPageOwnerState(userEntity.getId() == userId);
        dto.setImageCount(userEntity.getImages().size());

        /* 해당 유저의 좋아요 정보*/
        int subscribeState = subscribeRepository.mSubscribeState(userId, userEntity.getId());
        int subscribeCount = subscribeRepository.mSubscribeCount(userEntity.getId());

        dto.setSubscribeState(subscribeState == 1);
        dto.setSubscribeCount(subscribeCount);

        userEntity.getImages().forEach((image) -> {
            image.setLikeCount(image.getLikes().size());
        });


        return dto;


    }

    /* 게시글 수정 시 게시글 찾아오는 로직 */
    @Transactional(readOnly = true)
    public Image 이미지찾기(int imageId) {

        Image imageEntity = imageRepository.findById(imageId).orElseThrow(() -> {
            throw new CustomException("해당하는 이미지가 없습니다.");
        });

        return imageEntity;
    }

    /* 게시글 수정 로직 */
    @Transactional
    public Image 게시글수정(ImageUploadDto imageUploadDto, int imageId, PrincipalDetails principalDetails) {


        Image imageEntity = imageRepository.findById(imageId).orElseThrow(() -> {
            throw new CustomException("해당 게시물을 찾을 수 없습니다.");
        });

        /* 게시글 작성자와 접속한 유저 그리고 Role 확인 */
        int imageUserId = imageEntity.getUser().getId();
        int principalId = principalDetails.getUser().getId();
        String principalRole = principalDetails.getUser().getRole().toString();


        UUID uuid = UUID.randomUUID();
        String imageFileUrl = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();


        /* 이미지를 수정하는 유저가 게시글 유저 혹은 ADMIN 일 경우에만 수정 가능 */
        if (imageUserId == principalId || principalRole.equals("ADMIN")) {


            /* 게시글 부분 수정을 위한 로직입니다. 내용과 사진 중 둘중 하나만 수정할 경우 사용되는 로직입니다. */
            if (imageUploadDto.getFile().isEmpty()) {

                imageEntity.imageCaptionUpdate(
                        imageUploadDto.getCaption()
                );
            } else if (imageUploadDto.getCaption().isEmpty()) {

                imageEntity.imageImageUpdate(
                        imageFileUrl
                );

                Path imageFilePath = Paths.get(uploadFolder + imageFileUrl);


                try {
                    Files.write(imageFilePath, imageUploadDto.getFile().getBytes());

                } catch (Exception e) {
                    e.printStackTrace();
                }

                /* 게시글의 내용/사진 모두 업데이트 할 경우의 로직입니다.*/
            } else {

                imageEntity.imageAllUpdate(

                        imageUploadDto.getCaption(),
                        imageFileUrl
                );
                Path imageFilePath = Paths.get(uploadFolder + imageFileUrl);


                try {
                    Files.write(imageFilePath, imageUploadDto.getFile().getBytes());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            throw new CustomException("수정 할 권한이 없습니다.");
        }

        return imageEntity;
    }


}
