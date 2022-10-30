package com.sky.pro.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidlnputException extends RuntimeException{

    public InvalidlnputException() {
    }

    public InvalidlnputException(String message) {
        super(message);
    }

    public InvalidlnputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidlnputException(Throwable cause) {
        super(cause);
    }

    public InvalidlnputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
