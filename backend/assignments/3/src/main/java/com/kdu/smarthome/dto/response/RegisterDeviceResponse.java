package com.kdu.smarthome.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RegisterDeviceResponse {

    private String message;

    private String object;

    private HttpStatus httpStatus;

    public RegisterDeviceResponse(String message, String object, HttpStatus httpStatus) {
        this.message = message;
        this.object = object;
        this.httpStatus = httpStatus;
    }
}
