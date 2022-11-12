package com.dsimao11.sharedaccount.model.entities;

import com.dsimao11.sharedaccount.model.dto.outbound.CreateUserResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.FetchUserResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.UpdateUserResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Builder
@Getter
@Setter
public class User {

    @Id
    private String id;
    @Indexed
    private String nickname;

    public CreateUserResponseDto toCreateUserResponseDto() {
        return CreateUserResponseDto.builder()
                .id(id)
                .nickname(nickname)
                .build();
    }

    public FetchUserResponseDto toFetchUserResponseDto() {
        return FetchUserResponseDto.builder()
                .id(id)
                .nickname(nickname)
                .build();
    }

    public UpdateUserResponseDto toUpdateUserResponseDto() {
        return UpdateUserResponseDto.builder()
                .id(id)
                .nickname(nickname)
                .build();
    }
}
