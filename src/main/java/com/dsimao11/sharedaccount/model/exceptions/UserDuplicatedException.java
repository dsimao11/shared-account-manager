package com.dsimao11.sharedaccount.model.exceptions;

import com.dsimao11.sharedaccount.model.entities.User;

public class UserDuplicatedException extends EntityDuplicatedException {

    private static final String USER_TYPE_NAME = User.class.getSimpleName();
    private static final String FIELD_NAME = "nickname";


    public UserDuplicatedException(String nickname) {
        super(USER_TYPE_NAME, FIELD_NAME, nickname);
    }
}
