package com.pyo.yourspick.domain.postcomment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment , Integer> {

    List<PostComment> findByPostId(int postId);
}
