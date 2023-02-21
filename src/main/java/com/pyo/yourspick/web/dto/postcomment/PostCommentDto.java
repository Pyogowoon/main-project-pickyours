package com.pyo.yourspick.web.dto.postcomment;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostCommentDto {

    private int postId;

    @NotBlank
    private String content;

    @NotNull
    private String commentUser;


}
