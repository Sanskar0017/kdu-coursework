package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseResponse {

    private String message;

    @NotNull(message = "House details are mandatory")
    private House house;

    private HttpStatus httpStatus;

}
