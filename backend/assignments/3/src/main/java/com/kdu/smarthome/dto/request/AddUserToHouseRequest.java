package com.kdu.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserToHouseRequest {

    @NotBlank(message = "Username is mandatory")
    private String username;

    // Access control and validation for adding users based on roles

}
