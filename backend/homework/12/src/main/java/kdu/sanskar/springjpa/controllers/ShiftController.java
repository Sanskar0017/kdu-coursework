package kdu.sanskar.springjpa.controllers;

import kdu.sanskar.springjpa.model.Shifts;
import kdu.sanskar.springjpa.services.ShiftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public ResponseEntity<String> addShift(@RequestBody Shifts shift) {
        log.info("Adding shift {}", shift);
        shiftService.addShift(shift);
        return new ResponseEntity<>("Successfully added shift", HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve the top 3 shifts within a specified date range.
     *
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @return ResponseEntity containing a list of the top 3 shifts within the specified date range.
     */
    @GetMapping("/top3")
    public ResponseEntity<List<Shifts>> getTop3Shifts(
            @RequestParam("startDate") Date startDate,
            @RequestParam("endDate") Date endDate) {
        List<Shifts> shiftsList = shiftService.findTop3Shifts(startDate, endDate);
        return new ResponseEntity<>(shiftsList, HttpStatus.OK);
    }
}
