package com.kdu.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryItemRequest {
    @NotBlank(message = "Kickston ID is mandatory")
    private String kickstoneId;

    @NotBlank(message = "Device username is mandatory")
    private String deviceUsername;

    @NotBlank(message = "Device password is mandatory")
    private String devicePassword;

    private String manufactureDateTime;

    @NotBlank(message = "Manufacturing factory place is mandatory")
    private String manufactureFactoryPlace;

}
