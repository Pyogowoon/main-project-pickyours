package com.pyo.yourspick.web.api;


import com.pyo.yourspick.config.auth.PrincipalDetails;
import com.pyo.yourspick.domain.user.User;
import com.pyo.yourspick.handler.ex.CustomValidationApiException;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import com.pyo.yourspick.service.SubscribeService;
import com.pyo.yourspick.service.UserService;
import com.pyo.yourspick.web.dto.CMRespDto;
import com.pyo.yourspick.web.dto.subscribe.SubscribeDto;
import com.pyo.yourspick.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    private final SubscribeService subscribeSerivce;


    /* 구독 리스트 불러오기 요청 */
    @GetMapping("/api/user/{pageUserId}/subscribe")
    public ResponseEntity<?> subscribeList(@PathVariable int pageUserId, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        List<SubscribeDto> subscribeDto = subscribeSerivce.구독리스트(principalDetails.getUser().getId(), pageUserId);

        return new ResponseEntity<>(new CMRespDto<>(1, "구독 정보 리스트 가져오기 성공", subscribeDto), HttpStatus.OK);
    }


    /* 회원 수정 요청 */
    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@Valid UserUpdateDto userUpdateDto
            , BindingResult bindingResult
            , @PathVariable int id
            , @AuthenticationPrincipal PrincipalDetails principalDetails) {

        User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1, "업데이트 완료", userEntity);

    }


    /* 회원 프로필 사진 변경 요청*/
    @PutMapping("/api/user/{principalId}/profileImageUrl")
    public ResponseEntity<?> profileImageUrlUpdate(@PathVariable int principalId, MultipartFile profileImageFile,
                                                   @AuthenticationPrincipal PrincipalDetails principalDetails) {

        User userEntity = userService.회원프로필사진변경(principalId, profileImageFile);
        principalDetails.setUser(userEntity);
        return new ResponseEntity<>(new CMRespDto<>(1, "프로필사진 변경 성공", null), HttpStatus.OK);
    }

}
