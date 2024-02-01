package com.sanskar.springexercise3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for authentication.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

    /**
     * The username for authentication.
     */
    private String userName;

    /**
     * The password for authentication.
     */
    private String password;
}
