package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.postcomment.PostCommentRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;

    public PostComment 댓글달기(int userId,String content){

       User userEntity = userRepository.findById(userId).orElseThrow(()->{
           throw new IllegalArgumentException("아이디를 찾을 수 없습니다");
       });

        PostComment postComment = new PostComment();
        postComment.setUser(userEntity);
        postComment.setContent(content);

        return postCommentRepository.save(postComment);



    }


}
