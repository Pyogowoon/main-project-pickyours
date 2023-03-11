package com.pyo.yourspick.handler.aop;


import com.pyo.yourspick.handler.ex.CustomValidationApiException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.web.dto.CMRespDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class ValidationAdvice {

    /* Around 사용으로 호출 가로채기 */
    @Around("execution(* com.pyo.yourspick.web.api.CommentApiController.*(..))")
    public Object apiAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        /* proceedingJoinPoint 를 통한 BindingResult 인스턴스의 실행 감지 */
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            /* BindingResult 감지 */
            if (arg instanceof BindingResult) {

                BindingResult bindingResult = (BindingResult) arg;
                /* BindingResult에 Error 감지 */
                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    /* Error를 ErroeMap 에 put */
                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                    }
                    return new ResponseEntity<>(new CMRespDto<>(-1 ," 댓글을 입력해주세요." , null), HttpStatus.BAD_REQUEST);
                }
            }
        }
        /* proceed 메서드 호출 */
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
                    return new ResponseEntity<>(new CMRespDto<>(-1, " 모든 항목을 입력해주세요.", null), HttpStatus.BAD_REQUEST);
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

}

/* 경로 저장용 입니다. */
// @Around("execution(* com.pyo.yourspick.web.api.*Controller.*(..))")