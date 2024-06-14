package com.kdu.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseRequest {

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "House name is mandatory")
    private String houseName;

}
