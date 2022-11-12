package com.dsimao11.sharedaccount.controller;

import com.dsimao11.sharedaccount.model.dto.outbound.ErrorResponse;
import com.dsimao11.sharedaccount.model.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e, WebRequest request) {
        ErrorResponse body = new ErrorResponse(
                e.getStatus(),
                new Date(),
                request.getDescription(false),
                e.getMessage());

        return ResponseEntity.status(e.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(RuntimeException e, WebRequest request) {
        ErrorResponse body = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                new Date(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(500)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}
