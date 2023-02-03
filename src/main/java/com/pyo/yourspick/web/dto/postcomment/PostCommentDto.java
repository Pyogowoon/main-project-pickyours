package com.pyo.yourspick.web.dto.postcomment;


import lombok.Data;

@Data
public class PostCommentDto {

    private int postId;

    private String content;

    private String commentUser;


}
