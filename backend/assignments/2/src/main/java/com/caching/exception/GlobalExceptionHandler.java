package com.caching.exception;

import com.caching.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for mapping exceptions to appropriate HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles custom exceptions of type MappingParameterException.
     *
     * @param ex The MappingParameterException instance.
     * @return ResponseEntity containing the error message and HTTP status code.
     */
    @ExceptionHandler(value = {MappingParameterException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(MappingParameterException ex) {
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [MyCustomException]", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles all other exceptions of type Exception.
     *
     * @param ex The Exception instance.
     * @return ResponseEntity containing the error message and HTTP status code.
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception ex) {
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [Parent Exception]", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
