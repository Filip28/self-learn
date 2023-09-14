package com.app.selflearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AuthUserAlreadySignedUp extends RuntimeException {

    public AuthUserAlreadySignedUp(String message) {
        super(message);
    }
}
