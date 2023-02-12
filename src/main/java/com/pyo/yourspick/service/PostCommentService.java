package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.postcomment.PostComment;
import com.pyo.yourspick.domain.postcomment.PostCommentRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;

    public PostComment 댓글달기(int userId,String content,int postId){

       User userEntity = userRepository.findById(userId).orElseThrow(()->{
           throw new CustomApiException("아이디를 찾을 수 없습니다");
       });
       Post post = new Post();
       post.setId(postId);


        PostComment postComment = new PostComment();
        postComment.setUser(userEntity);
        postComment.setContent(content);
        postComment.setPost(post);
        postComment.setCommentUser(userEntity.getUsername());

        return postCommentRepository.save(postComment);
    }

        public void 댓글삭제(int commentId){


                postCommentRepository.deleteById(commentId);


        }



}
