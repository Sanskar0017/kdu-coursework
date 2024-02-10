package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHouseAddressResponse {

    private String message;

    // Consider returning more meaningful information about the updated house
    private String object;

    private HttpStatus httpStatus;

}
