package com.kdu.smarthome.exception;

public class InvalidCredentialsException extends Exception{

    /**
     * Constructs a new MyCustomException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public InvalidCredentialsException(String message) {
        super(message);
    }

}
