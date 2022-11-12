package com.dsimao11.sharedaccount.model.exceptions;

import com.dsimao11.sharedaccount.model.entities.User;

public class UserNotFoundException extends EntityNotFoundException {

    private static final String USER_TYPE_NAME = User.class.getSimpleName();

    public UserNotFoundException(String userId) {
        super(USER_TYPE_NAME, userId);
    }
}
