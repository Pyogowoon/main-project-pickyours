package com.pyo.yourspick.service;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.image.ImageRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.web.dto.image.ImageUploadDto;
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
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadFolder;


    @Transactional(readOnly = true)
    public void 이미지업로드(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails){
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid+"_"+imageUploadDto.getFile().getOriginalFilename();

        Path imageFilePath = Paths.get(uploadFolder+imageFileName);


        try{
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());

        }catch(Exception e){
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser());
        Image imageEntity = imageRepository.save(image);

    }

    @Transactional(readOnly = true)
    public Page<Image> 이미지스토리(int principalId , Pageable pageable){

//        imageRepository.findById(principalId).orElseThrow(()->{
//            throw new CustomApiException("아이디를 찾을 수 없습니다. .");
//        });
        Page<Image> images = imageRepository.mStory(principalId, pageable);

            images.forEach((image) ->{

                image.setLikeCount(image.getLikes().size());

                image.getLikes().forEach((like) ->{
                    if(like.getUser().getId() == principalId){
                        image.setLikeState(true);
                    }

                });

            });

            return images;
    }

    @Transactional(readOnly = true)
    public List<Image> 인기사진(){

        return imageRepository.mPopular();


    }

    @Transactional
    public void 게시글삭제(int imageId){
        imageRepository.deleteById(imageId);
        System.out.println("삭제서비스 도달");

    }

}
