package com.pyo.yourspick.service;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.post.PostRepository;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.web.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Transactional
    public Post 게시글저장(PostDto postDto , PrincipalDetails principalDetails){
//        if(userRole.equals("USER")){
//            System.out.println("유저입니다");
//
//
//            postRepository.save(post);
//        }else{
//            System.out.println("유저가 아닙니다.");
//        }
//        userRepository.findById(userId);
        User user = principalDetails.getUser();
        Post post = postDto.toEntity(user);

       return postRepository.save(post);





    }
}
