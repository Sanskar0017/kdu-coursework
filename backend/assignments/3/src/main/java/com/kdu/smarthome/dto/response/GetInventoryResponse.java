package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInventoryResponse {

    private String message;

    @NotEmpty(message = "Inventory cannot be empty")
    private List<Inventory> inventory; // List of devices in the inventory

    private HttpStatus httpStatus;

}