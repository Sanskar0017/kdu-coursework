package com.sanskar.springassessment.controller;

import com.sanskar.springassessment.dto.EventDTO;
import com.sanskar.springassessment.exception.custom.RecordNotFoundException;
import com.sanskar.springassessment.service.EventService;
import com.sun.net.httpserver.HttpsServer;
import jakarta.validation.Valid;
import jdk.jfr.Event;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * EventController for api fetch and calling
 */
@RestController
@Slf4j
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEvent(@RequestBody EventDTO eventDTO)  {
        try{
            log.info("Record event entry");
            eventService.addEvent(eventDTO);
            return new ResponseEntity<>("Successfully Added", HttpStatus.OK);
        }catch(Exception e){
            throw new RecordNotFoundException("Record not found");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@Valid @PathVariable("id") int eventId){
        try{
            log.info("Record event deletion");
            eventService.deleteEvent(eventId);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }catch(Exception e){
            throw new RecordNotFoundException("Record not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEvent(@Valid @PathVariable("id") int eventId, @RequestBody EventDTO eventDTO){
        try{
            log.info("Updating event");
            eventService.updateEvent(eventId, eventDTO);
            return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
        }catch(Exception e){
            throw new RecordNotFoundException("Record not found");
        }
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Integer> availableTickets(@Valid @PathVariable("id") int eventId){
        log.info("tickets finding");
        int tickets = eventService.availableTickets(eventId);
        return new ResponseEntity<>(Integer.parseInt(String.valueOf(tickets)), HttpStatus.OK);
    }

    @PostMapping("/reserveticket")
    public ResponseEntity<Integer> reserveTicket(@Valid @PathVariable("id") int eventId)  {
        try{
            log.info("Record event entry");
            int tickets = eventService.reserveEvent(eventId);
            return new ResponseEntity<>(Integer.parseInt(String.valueOf(tickets)), HttpStatus.OK);
        }catch(Exception e){
            throw new RecordNotFoundException("Record not found");
        }

    }


}

