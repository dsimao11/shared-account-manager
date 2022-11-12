package com.dsimao11.sharedaccount.model.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class CustomException extends RuntimeException {

    private final HttpStatus status;

    protected CustomException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
