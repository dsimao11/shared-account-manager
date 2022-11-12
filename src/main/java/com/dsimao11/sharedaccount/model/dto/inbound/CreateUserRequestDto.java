package com.dsimao11.sharedaccount.model.dto.inbound;

import com.dsimao11.sharedaccount.model.entities.User;

import javax.validation.constraints.NotEmpty;

public class CreateUserRequestDto {

    @NotEmpty
    public String nickname;

    public User toUser() {
        return User.builder()
                .id(null)
                .nickname(nickname)
                .build();
    }
}
