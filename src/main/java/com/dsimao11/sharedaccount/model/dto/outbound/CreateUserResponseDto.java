package com.dsimao11.sharedaccount.model.dto.outbound;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class CreateUserResponseDto {

    private String id;
    private String nickname;
}
