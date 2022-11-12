package com.dsimao11.sharedaccount.model.enumerators;

public enum PaymentStrategy {
    /*
     * 16 euros <> 3 users
     * splitMonthly -> 16/3 euros each user per month MVP
     * eachUserPerMonth -> 16 euros each 3 months FUTURE FEATURE
     * singleAnnuallyPayment -> (16*12)/3 each year FUTURE FEATURE
     * */

    SPLIT_MONTHLY;
}
