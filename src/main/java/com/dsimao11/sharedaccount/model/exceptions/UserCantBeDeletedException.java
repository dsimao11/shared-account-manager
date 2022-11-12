package com.dsimao11.sharedaccount.model.exceptions;

import com.dsimao11.sharedaccount.model.entities.SharedAccount;

import java.util.List;

public class UserCantBeDeletedException extends ConflictException {

    public static final String ENTITY_NOT_FOUND_EXCEPTION_MESSAGE = "The User with the nickname '%s' can't be deleted because belongs to the following Shared Accounts: %s";

    public UserCantBeDeletedException(String userId, List<SharedAccount> sharedAccounts) {
        super(String.format(ENTITY_NOT_FOUND_EXCEPTION_MESSAGE, userId, sharedAccounts));
    }
}
