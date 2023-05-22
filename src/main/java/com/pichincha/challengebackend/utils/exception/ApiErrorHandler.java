package com.pichincha.challengebackend.utils.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ApiErrorHandler {

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<ApiExceptionResponse> errorHandler(ApiException apiException) {
        return new ResponseEntity<>(build(apiException.getReason()), apiException.getStatus());
    }

    private ApiExceptionResponse build(String reason) {
        return ApiExceptionResponse.builder().timestamp(new Date()).message(reason).build();
    }

}
