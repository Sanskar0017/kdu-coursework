package com.sanskar.springexercise3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ErrorDTO represents a data transfer object for error messages and status codes.
 */
@Data
@AllArgsConstructor
public class ErrorDTO {
    /** The error message. */
    private String message;

    /** The status code associated with the error. */
    private int statusCode;
}
