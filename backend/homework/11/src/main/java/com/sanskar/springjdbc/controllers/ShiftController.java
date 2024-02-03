package com.sanskar.springjdbc.controllers;

import com.sanskar.springjdbc.dto.ShiftDTO;
import com.sanskar.springjdbc.services.ShiftService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing Shift entities.
 */
@RestController
@Slf4j
public class ShiftController {

    private final ShiftService shiftService;

    /**
     * Constructor-based dependency injection for ShiftController.
     *
     * @param shiftService The ShiftService instance to be injected.
     */
    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    /**
     * Endpoint to add a new shift.
     *
     * @param shift The ShiftDTO object representing the shift to be added.
     * @return ResponseEntity indicating the result of the operation.
     */
    @PostMapping("/addShift")
    public ResponseEntity<String> addShift(@Valid @RequestBody ShiftDTO shift) {
        log.info("Adding shift {}", shift);
        shiftService.addShiftService(shift);
        return new ResponseEntity<>("Successfully added shift", HttpStatus.OK);
    }

}
