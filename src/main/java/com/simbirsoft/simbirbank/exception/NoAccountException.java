package com.simbirsoft.simbirbank.exception;

public class NoAccountException extends RuntimeException {
    public NoAccountException() {
    }

    public NoAccountException(String message) {
        super(message);
    }
}
