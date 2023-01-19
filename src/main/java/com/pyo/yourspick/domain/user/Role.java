package com.pyo.yourspick.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST" , "손님"),
    ADMIN("ROLE_ADMIN" , "운영자"),
    SUPERADMIN("ROLE_SUPERADMIN" , "최고운영자"),
    USER("ROLE_USER" , "일반 사용자");

    private final String key;
    private final String title;
}
