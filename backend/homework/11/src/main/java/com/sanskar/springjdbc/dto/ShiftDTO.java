package com.sanskar.springjdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

/**
 * Data Transfer Object for Shift information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftDTO {

    /** Unique identifier for the shift. */
    private UUID id;

    /** Unique identifier for the shift type associated with the shift. */
    private UUID shiftTypeID;

    /** Name of the shift. */
    private String name;

    /** Start date of the shift. */
    private Date startDate;

    /** End date of the shift. */
    private Date endDate;

    /** Start time of the shift. */
    private Time startTime;

    /** End time of the shift. */
    private Time endTime;

    /** Date and time when the shift was created. */
    private Date createdAt;

    /** Date and time when the shift was last updated. */
    private Date updatedAt;

    /** User who created the shift. */
    private String createdBy;

    /** User who last updated the shift. */
    private String updatedBy;
}
