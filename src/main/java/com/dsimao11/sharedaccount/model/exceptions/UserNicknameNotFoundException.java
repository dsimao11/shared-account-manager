package com.dsimao11.sharedaccount.model.exceptions;

import com.dsimao11.sharedaccount.model.entities.User;

public class UserNicknameNotFoundException extends EntityNotFoundException {

    private static final String USER_TYPE_NAME = User.class.getSimpleName();
    private static final String NICKNAME_FIELD_NAME = "nickname";

    public UserNicknameNotFoundException(String userId) {
        super(USER_TYPE_NAME, NICKNAME_FIELD_NAME, userId);
    }
}
