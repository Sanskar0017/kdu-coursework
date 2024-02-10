package com.kdu.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceToHouseRequest {

    @NotBlank(message = "House ID is mandatory")
    private String houseId;

    @NotBlank(message = "Room ID is mandatory")
    private String roomId;

    @NotBlank(message = "Kickston ID is mandatory")
    private String kickstoneId;

}
