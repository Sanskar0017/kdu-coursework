package com.kdu.smarthome.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHouseAddressRequest {

    @NotBlank(message = "New address is mandatory")
    private String newAddress;

}
