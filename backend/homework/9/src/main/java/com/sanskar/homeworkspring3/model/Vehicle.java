package com.sanskar.homeworkspring3.model;

import lombok.*;


/**
 * Vehicle class referenced as data type for @type Vehicle
 */
@Data
@AllArgsConstructor
public class Vehicle {
    private String name;
    private Double price;
}
