package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {

    private String message;

    @NotBlank(message = "Token is mandatory")
    private String token;

}
