package com.pyo.yourspick.domain.image;

import com.pyo.yourspick.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    /* 유저마당 이미지 가져오기 조건 : 접속 아이디가 저장한 구독 가져옴 */
    @Query(value = "SELECT * FROM Image WHERE userId IN (SELECT toUserId FROM Subscribe WHERE fromUserId = :principalId) ORDER BY id DESC", nativeQuery = true)
    Page<Image> mStory(@Param("principalId") int principalId, Pageable pageable);

    /* 인기페이지 가져오기 DESC */
    @Query(value = "SELECT i.* FROM Image i INNER JOIN (SELECT imageId, COUNT(imageId) likeCount FROM Likes GROUP BY imageId) c ON i.id = c.imageId ORDER BY likeCount DESC", nativeQuery = true)
    List<Image> mPopular();

    List<Image> findByUserId(int userId);


}
