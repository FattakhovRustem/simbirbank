package com.simbirsoft.simbirbank.exception;

public class NoMoneyException extends RuntimeException {
    public NoMoneyException() {
    }

    public NoMoneyException(String message) {
        super(message);
    }
}
