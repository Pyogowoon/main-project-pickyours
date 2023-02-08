package com.pyo.yourspick.domain.post;

import com.pyo.yourspick.domain.postlikes.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post , Integer> {


    Optional<Post> findByUserId(int userId);
}
