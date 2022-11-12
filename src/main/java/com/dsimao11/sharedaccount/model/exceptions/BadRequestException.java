package com.dsimao11.sharedaccount.model.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends CustomException {

    public static final String BAD_REQUEST_EXCEPTION_MESSAGE = "";

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, String.format(message));
    }
}
