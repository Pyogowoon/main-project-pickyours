package com.pyo.yourspick.handler.aop;


import com.pyo.yourspick.handler.ex.CustomValidationApiException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class ValidationAdvice {
   // @Around("execution(* com.pyo.yourspick.web.api.*Controller.*(..))")
    @Around("execution(* com.pyo.yourspick.web.api.CommentApiController.*(..))")
    public Object apiAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {

                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                    }
                    throw new CustomValidationApiException("내용을 입력해주세요." , errorMap);
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

    @Around("execution(* com.pyo.yourspick.web.api.UserApiController.*(..))")
    public Object apiUpdateAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {

                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                    }
                    throw new CustomValidationApiException("이름 , 유저네임, 이메일은 바뀔수없습니다." , errorMap);
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

    @Around("execution(* com.pyo.yourspick.web.api.PostApiController.*(..))")
    public Object PostApiAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {

                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                    }
                    throw new CustomValidationApiException("모든 항목을 채워주세요." , errorMap);
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

}
