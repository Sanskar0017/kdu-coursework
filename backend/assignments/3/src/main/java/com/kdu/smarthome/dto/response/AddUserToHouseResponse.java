package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserToHouseResponse {

    private String message;

    // Include relevant information about the added user, e.g., role within the house
    private String object;
    private HttpStatus httpStatus;

}
