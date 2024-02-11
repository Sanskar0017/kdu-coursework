package com.sanskar.springassessment.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * reserve class for api referencing and fetching reserve tickets
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reserve")
@Entity
public class ReserveDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reserveId;
    private int reservedTickets;

}
