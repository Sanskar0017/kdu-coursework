package com.sanskar.homeworkspring3.exception;

import com.sanskar.homeworkspring3.vehicledto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler is handling custom exceptions and general exceptions, inherited from Exception
 * @author Sanskar
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MyCustomException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(MyCustomException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [MyCustomException]", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [Parent Exception]", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
