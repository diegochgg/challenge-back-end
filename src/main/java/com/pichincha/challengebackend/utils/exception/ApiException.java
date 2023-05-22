package com.pichincha.challengebackend.utils.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class ApiException extends ResponseStatusException {
    public ApiException(HttpStatus status) {
        super(status);
    }

    public ApiException(HttpStatus status, String reason) {
        super(status, reason);
    }

}
