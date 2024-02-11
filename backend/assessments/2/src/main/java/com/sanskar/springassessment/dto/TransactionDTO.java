package com.sanskar.springassessment.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * Managing transaction for each event and user booking
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @CreationTimestamp
    private Date date;

    private int totalAmount;

    @OneToOne
    @JoinColumn(name = "name")
    private EventDTO eventDTO;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private TicketDTO ticketDTO;

}
