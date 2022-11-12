package com.dsimao11.sharedaccount.model.exceptions;

import com.dsimao11.sharedaccount.model.entities.SharedAccount;

public class SharedAccountNotFoundException extends EntityNotFoundException {

    private static final String SHARED_ACCOUNT_TYPE_NAME = SharedAccount.class.getSimpleName();

    public SharedAccountNotFoundException(String sharedAccountId) {
        super(SHARED_ACCOUNT_TYPE_NAME, sharedAccountId);
    }
}
