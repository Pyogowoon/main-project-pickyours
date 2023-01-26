package com.pyo.yourspick.web.dto.user;

import com.pyo.yourspick.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto {

    private boolean pageOwnerState;

    private User user;

    private int imageCount;

    private boolean subscribeState;

    private int subscribeCount;


}
