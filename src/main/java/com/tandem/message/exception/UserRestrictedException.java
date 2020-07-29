package com.tandem.message.exception;

public class UserRestrictedException extends RuntimeException {
    public UserRestrictedException(String message) {
        super(message);
    }
}
