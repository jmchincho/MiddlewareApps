package com.middleware.app.cow.exceptions;


public class CowException extends Exception {

    public CowException() {
    }

    public CowException(String message) {
        super(message);
    }

    public CowException(String message, Throwable cause) {
        super(message, cause);
    }
}
