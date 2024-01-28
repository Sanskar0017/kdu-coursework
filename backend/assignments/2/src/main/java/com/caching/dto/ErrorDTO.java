package com.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Data Transfer Object (DTO) representing an error response.
 */
@Data
@AllArgsConstructor
public class ErrorDTO {
    /**
     * The error message.
     */
    private String message;

    /**
     * The HTTP status code associated with the error.
     */
    private HttpStatus statusCode;
}
