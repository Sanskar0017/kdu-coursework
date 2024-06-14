package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.House;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class GetHousesResponse {

    private String message;

    private List<House> houses; // List of House DTOs

    private HttpStatus httpStatus;

    public GetHousesResponse(String message, List<House> houses, HttpStatus httpStatus) {
        this.message = message;
        this.houses = houses;
        this.httpStatus = httpStatus;
    }
}
