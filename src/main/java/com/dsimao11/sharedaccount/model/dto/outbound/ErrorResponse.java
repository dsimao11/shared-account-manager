package com.dsimao11.sharedaccount.model.dto.outbound;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus status;
    private Date date;
    private String url;
    private String message;

}
