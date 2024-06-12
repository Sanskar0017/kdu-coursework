package com.sanskar.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftUsers {

    private UUID id;
    private UUID shiftID;
    private UUID userID;
    private UUID tenantID;

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

}
