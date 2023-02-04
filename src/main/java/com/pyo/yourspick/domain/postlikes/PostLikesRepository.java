package com.pyo.yourspick.domain.postlikes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostLikesRepository extends JpaRepository<PostLikes , Integer> {

    @Modifying
    @Query(value ="INSERT INTO postlikes(postId ,userId,createDate) VALUES(:postId, :userId , NOW())" ,nativeQuery = true)
    int mLikes(@Param("postId") int postId , @Param("userId") int userId );

    @Modifying
    @Query(value="DELETE FROM postLikes where userId = :userId AND postId = :postId", nativeQuery = true)
    int mUnLikes(@Param("userId") int userId, @Param("postId") int postId);
}
