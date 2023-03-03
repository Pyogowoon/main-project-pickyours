package com.pyo.yourspick.service;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.post.PostRepository;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.postcomment.PostCommentRepository;
import com.pyo.yourspick.domain.postlikes.PostLikes;
import com.pyo.yourspick.domain.postlikes.PostLikesRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.handler.ex.CustomException;
import com.pyo.yourspick.web.dto.post.PostDto;
import com.pyo.yourspick.web.dto.post.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    private final PostCommentRepository postCommentRepository;

    private final PostLikesRepository postLikesRepository;

    private final UserRepository userRepository;


    @Value("${file.path}")
    private String uploadFolder;


    @Transactional
    public Post 게시글저장(PostDto postDto, PrincipalDetails principalDetails
            , MultipartFile clotheImage, MultipartFile actorImage, MultipartFile video) {


        UUID uuid = UUID.randomUUID();
        String actorImageFileName = uuid + "_" + actorImage.getOriginalFilename();
        String clotheImageFileName = uuid + "_" + clotheImage.getOriginalFilename();
        String videoFileName = uuid + "_" + video.getOriginalFilename();

        Path actorImageFilePath = Paths.get(uploadFolder + actorImageFileName);
        Path clotheImageFilePath = Paths.get(uploadFolder + clotheImageFileName);
        Path videoFilePath = Paths.get(uploadFolder + videoFileName);

        try {
            Files.write(actorImageFilePath, actorImage.getBytes());
            Files.write(clotheImageFilePath, clotheImage.getBytes());
            Files.write(videoFilePath, video.getBytes());
        } catch (Exception e) {
            e.printStackTrace();

        }

        User user = principalDetails.getUser();
        Post post = postDto.toEntity(user, actorImageFileName, clotheImageFileName, videoFileName);

       return postRepository.save(post);

    }

    @Transactional(readOnly = true)
    public Page<Post> 포스트로드(Pageable pageable) {
        Page<Post> post = postRepository.findAll(pageable);
        return post;
    }

    @Transactional(readOnly = true)
    public Post 포스트상세보기(int postId) {

        Post postEntity = postRepository.findById(postId).orElseThrow(() -> {
            throw new CustomException("게시글을 찾을 수 없습니다");
        });

        return postEntity;
    }

    @Transactional(readOnly = true)
    public List<PostComment> 댓글불러오기(int postId) {

        List<PostComment> comment = postCommentRepository.findByPostId(postId);

        return comment;
    }


    @Transactional(readOnly = true)
    public PostLikes 좋아요목록(int userId, int postId) {

        PostLikes postLikes = postLikesRepository.findByUserIdAndPostId(userId, postId);


        return postLikes;
    }


    @Transactional
    public void 좋아요하기(int postId, int userId) {

        postLikesRepository.mLikes(postId, userId);

    }

    @Transactional
    public void 좋아요취소하기(int postId, int userId) {

        postLikesRepository.mUnLikes(userId, postId);

    }

    @Transactional
    public Post 게시글수정(PostUpdateDto postUpdateDto, MultipartFile actorImage,
                      MultipartFile clotheImage, MultipartFile video, PrincipalDetails principalDetails, int postId) {

        Post postEntity = postRepository.findById(postId).orElseThrow(() -> {
            throw new CustomApiException("아이디 찾기 불가");
        });


        UUID uuid = UUID.randomUUID();
        String actorImageFileName = uuid + "_" + actorImage.getOriginalFilename();
        String clotheImageFileName = uuid + "_" + clotheImage.getOriginalFilename();
        String videoFileName = uuid + "_" + video.getOriginalFilename();


        Path actorImageFilePath = Paths.get(uploadFolder + actorImageFileName);
        Path clotheImageFilePath = Paths.get(uploadFolder + clotheImageFileName);
        Path videoFilePath = Paths.get(uploadFolder + videoFileName);

        try {
            Files.write(actorImageFilePath, actorImage.getBytes());
            Files.write(clotheImageFilePath, clotheImage.getBytes());
            Files.write(videoFilePath, video.getBytes());
        } catch (Exception e) {
            e.printStackTrace();

        }

        User userEntity = principalDetails.getUser();

        postEntity.update(
                userEntity,
                postUpdateDto.getTitle(),
                postUpdateDto.getContent(),
                postUpdateDto.getEntryTitle(),
                postUpdateDto.getEntryContent(),
                postUpdateDto.getActor(),
                postUpdateDto.getJob(),
                postUpdateDto.getHeight(),
                postUpdateDto.getWeight()
        );


        if (!actorImage.getOriginalFilename().isEmpty()) {
            postEntity.leftImageUpdate(actorImageFileName);

        }

        if (!clotheImage.getOriginalFilename().isEmpty()) {
            postEntity.rightImageUpdate(clotheImageFileName);

        }
        if (!video.getOriginalFilename().isEmpty()) {
            postEntity.videoUpdate(videoFileName);

        }
        return postEntity;


    }

    @Transactional
    public void 게시글삭제(int postId) {

        postRepository.deleteById(postId);

    }

    @Transactional(readOnly = true)
    public Page<Post> 게시글검색(String keyword, Pageable pageable) {

        Page<Post> postSearch = postRepository.findByTitleContaining(keyword, pageable);


        return postSearch;
    }


}

