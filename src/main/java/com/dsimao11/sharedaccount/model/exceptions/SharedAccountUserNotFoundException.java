package com.dsimao11.sharedaccount.model.exceptions;

import org.springframework.http.HttpStatus;

public class SharedAccountUserNotFoundException extends CustomException {

    public static final String SHARED_ACCOUNT_NOT_FOUND_EXCEPTION_MESSAGE = "The User with id '%s' doesn't belong to the SharedAccount with id '%s'";

    public SharedAccountUserNotFoundException(String userId, String sharedAccountId) {
        super(HttpStatus.NOT_FOUND, String.format(SHARED_ACCOUNT_NOT_FOUND_EXCEPTION_MESSAGE, userId, sharedAccountId));
    }
}
