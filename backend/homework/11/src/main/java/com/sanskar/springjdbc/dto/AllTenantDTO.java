package com.sanskar.springjdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a DTO (Data Transfer Object) containing information about all tenant entities.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllTenantDTO {

    /**
     * The DTO containing information about the user.
     */
    private UserDTO userDTO;

    /**
     * The DTO containing information about the shift type.
     */
    private ShiftTypeDTO shiftTypeDTO;

    /**
     * The DTO containing information about the shift user.
     */
    private ShiftUserDTO shiftUserDTO;

    /**
     * The DTO containing information about the shift.
     */
    private ShiftDTO shiftDTO;
}
