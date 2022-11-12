package com.dsimao11.sharedaccount.model.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends CustomException {

    public static final String ENTITY_NOT_FOUND_EXCEPTION_MESSAGE = "The %s with %s '%s' was not found";

    public EntityNotFoundException(String entityType, String entityId) {
        super(HttpStatus.NOT_FOUND, String.format(ENTITY_NOT_FOUND_EXCEPTION_MESSAGE, entityType, "id", entityId));
    }

    public EntityNotFoundException(String entityType, String field, String entityId) {
        super(HttpStatus.NOT_FOUND, String.format(ENTITY_NOT_FOUND_EXCEPTION_MESSAGE, entityType, field, entityId));
    }
}
