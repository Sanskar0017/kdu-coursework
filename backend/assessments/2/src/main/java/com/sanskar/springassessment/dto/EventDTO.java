package com.sanskar.springassessment.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * Event class for api referencing events
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class EventDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String name;
    @CreationTimestamp
    private Date date;
    private String venue;
    private int availableTickets;

    @ManyToOne
    @JoinColumn(name = "reserve_id")
    private ReserveDTO reserveDTO;

    public int getReserveTicket(){
        return reserveDTO.getReserveId();
    }

}
