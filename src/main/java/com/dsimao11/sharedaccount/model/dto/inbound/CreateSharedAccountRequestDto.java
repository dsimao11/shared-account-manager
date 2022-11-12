package com.dsimao11.sharedaccount.model.dto.inbound;

import com.dsimao11.sharedaccount.model.entities.SharedAccount;
import com.dsimao11.sharedaccount.model.enumerators.PaymentStrategy;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;

public class CreateSharedAccountRequestDto {

    @NotEmpty
    public String platform;
    @NotNull
    @Positive
    public Double monthlyCost;

    public SharedAccount toSharedAccount() {
        return SharedAccount.builder()
                .id(null)
                .platform(platform)
                .monthlyCost(monthlyCost)
                .paymentStrategy(PaymentStrategy.SPLIT_MONTHLY)
                .users(new ArrayList<>())
                .build();
    }
}
