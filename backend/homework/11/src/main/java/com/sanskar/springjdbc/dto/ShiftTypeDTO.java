package com.sanskar.springjdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftTypeDTO {

    private UUID id;
    private String uqName;
    private String description;
    private boolean active;
    private String timeZone;
    private UUID tenantID;

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

}
