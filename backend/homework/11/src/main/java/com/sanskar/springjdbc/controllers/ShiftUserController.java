package com.sanskar.springjdbc.controllers;

import com.sanskar.springjdbc.dto.ShiftUserDTO;
import com.sanskar.springjdbc.services.ShiftUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing ShiftUser entities.
 */
@RestController
@Slf4j
public class ShiftUserController {

    private final ShiftUserService shiftUserService;

    /**
     * Constructor-based dependency injection.
     * @param shiftUserService the ShiftUserService to be injected
     */
    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService) {
        this.shiftUserService = shiftUserService;
    }

    /**
     * Endpoint for adding a ShiftUser.
     * @param shiftUser the ShiftUserDTO object to be added
     * @return ResponseEntity indicating success or failure of the operation
     */
    @PostMapping("/addShiftUser")
    public ResponseEntity<String> addShiftUser(@Valid @RequestBody ShiftUserDTO shiftUser){
        log.info("Adding User to Shift");
        shiftUserService.addShiftUser(shiftUser);
        return new ResponseEntity<>("Successfully added ShiftUser", HttpStatus.OK);
    }
}
