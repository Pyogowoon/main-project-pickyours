package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.likes.Likes;
import com.pyo.yourspick.domain.likes.LikesRepository;
import com.pyo.yourspick.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesRepository likesRepository;


    @Transactional
    public void 좋아요(int imageId, int principalId) {
        likesRepository.mLikes(imageId, principalId);


    }

    @Transactional
    public void 좋아요취소(int imageId, int principalId) {
        likesRepository.mUnLikes(imageId, principalId);


    }

}
