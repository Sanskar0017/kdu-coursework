package kdu.sanskar.springjpa.controllers;

import kdu.sanskar.springjpa.model.ShiftTypes;
import kdu.sanskar.springjpa.services.ShiftTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing shift types.
 */
@RestController
@Slf4j
public class ShiftTypeController {

    private final ShiftTypeService shiftTypeService;

    /**
     * Constructor for ShiftTypeController.
     *
     * @param shiftTypeService Service for managing shift types.
     */
    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    /**
     * Endpoint to add a new shift type.
     *
     * @param shift The shift type DTO to be added.
     * @return ResponseEntity indicating the success of the operation.
     */
    @PostMapping("/addShiftType")
    public ResponseEntity<String> addShiftType(@RequestBody ShiftTypes shift) {
        log.info("Adding shift {}", shift);
        shiftTypeService.addShiftTypeService(shift);
        return new ResponseEntity<>("Successfully added shiftType", HttpStatus.OK);
    }
}
