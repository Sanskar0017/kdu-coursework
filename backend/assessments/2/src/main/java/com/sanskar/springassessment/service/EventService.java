package com.sanskar.springassessment.service;

import com.sanskar.springassessment.dto.EventDTO;
import com.sanskar.springassessment.exception.custom.RecordNotFoundException;
import com.sanskar.springassessment.repository.EventRepository;
import com.sanskar.springassessment.repository.ReserveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementation of all the classes related to event api referencing
 */
@Service
@Slf4j
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository, ReserveRepository reserveRepository) {
        this.eventRepository = eventRepository;
    }

    public void addEvent(EventDTO eventDTO) {
        log.info("Saving event");
        eventRepository.save(eventDTO);

    }

    public void deleteEvent(int eventId) {
        EventDTO eventDTO = eventRepository.findById(eventId).orElseThrow(()-> new RecordNotFoundException("not found"));
        eventRepository.deleteById(eventDTO.getEventId());
    }

    public void updateEvent(int eventId, EventDTO eventDTO) {

        EventDTO eventdto = eventRepository.findById(eventId).orElseThrow(()-> new RecordNotFoundException("not found"));
        eventdto.setEventId(eventDTO.getEventId());
        eventdto.setName(eventDTO.getName());
        eventdto.setVenue(eventDTO.getVenue());

    }

    public int availableTickets(int eventId) {

        EventDTO eventDTO = eventRepository.findById(eventId).orElseThrow(() -> new RecordNotFoundException("record not found"));
        return eventDTO.getAvailableTickets();

    }

    public int reserveEvent(int eventId) {
        try{
            log.info("event id:" + eventId);
            return eventRepository.getTicket();
        }catch (Exception e){
            throw new RecordNotFoundException("record not found");
        }
    }
}
