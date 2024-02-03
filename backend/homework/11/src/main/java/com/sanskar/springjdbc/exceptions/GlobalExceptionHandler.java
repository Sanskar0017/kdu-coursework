package com.sanskar.springjdbc.exceptions;
import com.sanskar.springjdbc.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles instances of MyCustomException.
     * @param ex The MyCustomException instance
     * @return ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(RecordNotFoundException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [MyCustomException]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles instances of generic Exception class.
     * @param ex The Exception instance
     * @return ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [Parent Exception]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
