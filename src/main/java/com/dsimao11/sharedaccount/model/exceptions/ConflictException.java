package com.dsimao11.sharedaccount.model.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends CustomException {

    public static final String BAD_REQUEST_EXCEPTION_MESSAGE = "";

    public ConflictException(String message) {
        super(HttpStatus.CONFLICT, String.format(message));
    }
}
