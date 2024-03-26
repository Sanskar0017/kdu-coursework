package com.caching.exception;

/**
 * Exception thrown when mapping parameters are invalid.
 */
public class MappingParameterException extends RuntimeException {

    /**
     * Constructs a new MappingParameterException with the specified detail message.
     *
     * @param message the detail message.
     */
    public MappingParameterException(String message) {
        super(message);
    }
}
