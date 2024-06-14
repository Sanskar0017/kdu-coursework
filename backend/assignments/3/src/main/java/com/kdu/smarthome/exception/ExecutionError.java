package com.kdu.smarthome.exception;

public class ExecutionError extends Exception{

    /**
     * Constructs a new MyCustomException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ExecutionError(String message) {
        super(message);
    }

}
