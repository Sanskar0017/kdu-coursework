package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryItemResponse {

    private String message;

    // Consider returning more meaningful information about the added item
    private String object;

    private HttpStatus httpStatus;

}
