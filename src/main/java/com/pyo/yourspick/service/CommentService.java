package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.comment.Comment;
import com.pyo.yourspick.domain.comment.CommentRepository;
import com.pyo.yourspick.domain.image.Image;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.domain.user.UserRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.web.dto.comment.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;


    /* 댓글 쓰기 로직 */
    @Transactional
    public Comment 댓글쓰기(int imageId, String content, int userId) {

        Image image = new Image();
        image.setId(imageId);

        User userEntity = userRepository.findById(userId).orElseThrow(() -> {
            throw new CustomApiException("아이디를 찾을 수 없습니다.");
        });

        /* 간단하고 민감하지않은 정보이므로 간단한 new 객체를 통해 데이터를 집어넣는 로직 */
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setImage(image);
        comment.setUser(userEntity);

        return commentRepository.save(comment);
    }

    /* 댓글 삭제 */
    @Transactional
    public void 댓글삭제(int userId) {

        commentRepository.deleteById(userId);
    }
}
