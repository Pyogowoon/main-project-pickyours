package com.pyo.yourspick.web.dto.comment;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentDto {

    @NotBlank
    private String content;

    @NotNull
    private int imageId;
}
