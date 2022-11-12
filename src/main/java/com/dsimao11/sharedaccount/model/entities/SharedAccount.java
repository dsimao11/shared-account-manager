package com.dsimao11.sharedaccount.model.entities;

import com.dsimao11.sharedaccount.model.dto.outbound.CreateSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.FetchSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.dto.outbound.UpdateSharedAccountResponseDto;
import com.dsimao11.sharedaccount.model.enumerators.PaymentStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Builder
@Getter
@Setter
public class SharedAccount {

    @Id
    private String id;
    private String platform;
    private Double monthlyCost;
    private PaymentStrategy paymentStrategy;
    private ArrayList<SharedAccountUser> users;

    public CreateSharedAccountResponseDto toCreateSharedAccountResponseDto() {
        return CreateSharedAccountResponseDto.builder()
                .id(id)
                .platform(platform)
                .monthlyCost(monthlyCost)
                .paymentStrategy(paymentStrategy)
                .users(users)
                .build();
    }

    public FetchSharedAccountResponseDto toFetchSharedAccountResponseDto() {
        return FetchSharedAccountResponseDto.builder()
                .id(id)
                .platform(platform)
                .monthlyCost(monthlyCost)
                .paymentStrategy(paymentStrategy)
                .users(users)
                .build();
    }

    public UpdateSharedAccountResponseDto toUpdateSharedAccountResponseDto() {
        return UpdateSharedAccountResponseDto.builder()
                .id(id)
                .platform(platform)
                .monthlyCost(monthlyCost)
                .paymentStrategy(paymentStrategy)
                .users(users)
                .build();
    }
}
