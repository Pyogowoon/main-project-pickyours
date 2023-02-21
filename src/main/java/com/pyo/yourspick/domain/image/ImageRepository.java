package com.pyo.yourspick.domain.image;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image , Integer> {


    @Query(value = "SELECT * FROM Image WHERE userId IN (SELECT toUserId FROM Subscribe WHERE fromUserId = :principalId) ORDER BY id DESC" , nativeQuery = true)
    Page<Image> mStory(@Param("principalId") int principalId, Pageable pageable);

    @Query(value="SELECT i.* FROM Image i INNER JOIN (SELECT imageId, COUNT(imageId) likeCount FROM Likes GROUP BY imageId) c ON i.id = c.imageId ORDER BY likeCount DESC" , nativeQuery = true)
    List<Image> mPopular();


}
