package com.pyo.yourspick.domain.post;

import com.pyo.yourspick.domain.postlikes.PostLikes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post , Integer> {


    Optional<Post> findByUserId(int userId);

    Page<Post> findByTitleContaining(String keyword, Pageable pageable);
}
