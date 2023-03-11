package com.pyo.yourspick.handler;


import com.pyo.yourspick.handler.ex.CustomApiException;
import com.pyo.yourspick.handler.ex.CustomException;
import com.pyo.yourspick.handler.ex.CustomValidationApiException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.util.Script;
import com.pyo.yourspick.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {


    /* 유효성 예외처리 - 간단한 Alert 알림 */
    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {

        if (e.getErrorMap() == null) {
            return Script.back(e.getMessage());
        } else {
            return Script.back(e.getErrorMap().toString());
        }
    }

    /* 유효성 예외처리 - API Bad Request 리턴 */
    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<?> validationApiException(CustomValidationApiException e) {

        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);

    }

    /* 예외처리 - API 에서의 예외처리 */
    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e) {

        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);

    }

    /* 예외처리 - 단순 예외처리 */
    @ExceptionHandler(CustomException.class)
    public String exception(CustomException e) {
        return Script.back(e.getMessage());
    }


}
