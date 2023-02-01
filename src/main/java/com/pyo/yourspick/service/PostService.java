package com.pyo.yourspick.service;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.post.PostRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.web.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Value("${file.path}")
    private String uploadFolder;


    @Transactional
    public void 게시글저장(PostDto postDto , PrincipalDetails principalDetails
    , MultipartFile clotheImage,MultipartFile actorImage,MultipartFile video ){


//        if(userRole.equals("USER")){
//            System.out.println("유저입니다");
//            postRepository.save(post);
//        }else{
//            System.out.println("유저가 아닙니다.");
//        }
//        userRepository.findById(userId);


        System.out.println(clotheImage);
        System.out.println(actorImage);


        UUID uuid = UUID.randomUUID();
        String actorImageFileName = uuid+"_"+actorImage.getOriginalFilename();
        String clotheImageFileName = uuid+"_"+clotheImage.getOriginalFilename();
        String videoFileName = uuid+"_"+video.getOriginalFilename();
//
        Path actorImageFilePath = Paths.get(uploadFolder+actorImageFileName);
        Path clotheImageFilePath = Paths.get(uploadFolder+clotheImageFileName);
        Path videoFilePath = Paths.get(uploadFolder+videoFileName);
//
        try{
            Files.write(actorImageFilePath,actorImage.getBytes());
            Files.write(clotheImageFilePath,clotheImage.getBytes());
            Files.write(videoFilePath,video.getBytes());
        }catch(Exception e){
            e.printStackTrace();
//
        }
//
        User user = principalDetails.getUser();
            System.out.println("여기까지도달");
        Post post = postDto.toEntity(user,actorImageFileName,clotheImageFileName,videoFileName);
//
            postRepository.save(post);






    }
}
