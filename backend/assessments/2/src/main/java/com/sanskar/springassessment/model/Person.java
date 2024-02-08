/**
 * The User class represents a user entity in the application.
 */
package com.sanskar.springassessment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user entity with basic information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    /** The username of the user. */
    private String userName;

    /** The password of the user. */
    private String password;

    /** The email address of the user. */
    private String email;

    /** The role of the user. */
    private String role;
}
