package com.dsimao11.sharedaccount.model.exceptions;

import com.dsimao11.sharedaccount.model.entities.SharedAccount;

public class UserAlreadyPresentException extends ConflictException {

    public static final String ENTITY_DUPLICATED_EXCEPTION_MESSAGE = "The User with nickname '%s' is already present on the Shared Account with id '%s'";

    public UserAlreadyPresentException(String userId, SharedAccount sharedAccount) {
        super(String.format(ENTITY_DUPLICATED_EXCEPTION_MESSAGE, userId, sharedAccount.getId()));
    }
}
