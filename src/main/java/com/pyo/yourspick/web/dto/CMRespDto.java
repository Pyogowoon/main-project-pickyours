package com.pyo.yourspick.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {

    private int code;
    private String message;
    private T data;
}
