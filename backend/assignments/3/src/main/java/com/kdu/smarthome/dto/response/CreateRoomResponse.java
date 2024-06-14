package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomResponse {

    private String message;
    private Room room;

    private HttpStatus httpStatus;

}