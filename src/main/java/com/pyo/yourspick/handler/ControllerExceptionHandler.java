package com.pyo.yourspick.handler;


import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.util.Script;
import com.pyo.yourspick.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){

        return Script.back(e.getErrorMap().toString());
    }
}
