package com.dsimao11.sharedaccount.model.dto.outbound;

import com.dsimao11.sharedaccount.model.entities.SharedAccountUser;
import com.dsimao11.sharedaccount.model.enumerators.PaymentStrategy;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
@Getter
public class CreateSharedAccountResponseDto {

    private String id;
    private String platform;
    private Double monthlyCost;
    private PaymentStrategy paymentStrategy;
    private ArrayList<SharedAccountUser> users;
}
