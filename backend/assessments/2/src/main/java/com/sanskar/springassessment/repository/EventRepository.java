package com.sanskar.springassessment.repository;

import com.sanskar.springassessment.dto.EventDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Event repo consisting of eventDto
 */
@Repository
public interface EventRepository extends JpaRepository<EventDTO, Integer> {

    public default int getTicket(){
        EventDTO eventDTO = new EventDTO();
        return eventDTO.getReserveTicket();
    }
}
