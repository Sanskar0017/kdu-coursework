package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomsAndDevicesResponse {

    private String message;

    String roomsAndDevices;

    private HttpStatus httpStatus;
}

