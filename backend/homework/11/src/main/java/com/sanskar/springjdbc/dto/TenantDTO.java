package com.sanskar.springjdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantDTO {

    private UUID id;
    private String name;

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

}
