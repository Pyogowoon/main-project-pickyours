package com.pyo.yourspick.web.dto.postcomment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostCommentDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int postId;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NotBlank
    private String content;



}
