package com.pyo.yourspick.domain.postcomment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment , String> {
}
