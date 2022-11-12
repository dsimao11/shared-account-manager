package com.dsimao11.sharedaccount.model.exceptions;

public class EntityDuplicatedException extends ConflictException {

    public static final String ENTITY_DUPLICATED_EXCEPTION_MESSAGE = "Already exists a %s with the %s '%s'";

    public EntityDuplicatedException(String entityType, String fieldName, String fieldValue) {
        super(String.format(ENTITY_DUPLICATED_EXCEPTION_MESSAGE, entityType, fieldName, fieldValue));
    }
}
