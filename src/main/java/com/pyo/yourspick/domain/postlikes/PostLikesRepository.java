package com.pyo.yourspick.domain.postlikes;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostLikesRepository extends JpaRepository<PostLikes , Integer> {

    PostLikes findByUserIdAndPostId(int userId, int PostId);

    @Modifying
    @Query(value ="INSERT INTO PostLikes(postId ,userId,createDate) VALUES(:postId, :userId , NOW())" ,nativeQuery = true)
    int mLikes(@Param("postId") int postId , @Param("userId") int userId );

    @Modifying
    @Query(value="DELETE FROM PostLikes where userId = :userId AND postId = :postId", nativeQuery = true)
    int mUnLikes(@Param("userId") int userId, @Param("postId") int postId);



}


