package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceToHouseResponse {

    private String message;

    // Consider returning more meaningful information about the added device
    private String object;

    private HttpStatus httpStatus;

}
