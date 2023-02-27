package com.pyo.yourspick.domain.likes;

import com.pyo.yourspick.domain.postcomment.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Likes(imageId, userId, createDate) VALUES(:imageId, :userId, NOW()) ", nativeQuery = true)
    int mLikes(@Param("imageId") int imageId, @Param("userId") int userId);


    @Modifying
    @Query(value = "DELETE FROM Likes WHERE imageId = :imageId AND userId = :userId ", nativeQuery = true)
    int mUnLikes(@Param("imageId") int imageId, @Param("userId") int userId);

    Likes findByImageId(int imageId);
}
