package kdu.sanskar.springjpa.controllers;

import kdu.sanskar.springjpa.model.ShiftUsers;
import kdu.sanskar.springjpa.services.ShiftUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<String> addShiftUser(@RequestBody ShiftUsers shiftUser){
        log.info("Adding User to Shift");
        shiftUserService.addShiftUser(shiftUser);
        return new ResponseEntity<>("Successfully added ShiftUser", HttpStatus.OK);
    }

    /**
     * Endpoint for deleting a ShiftUser.
     * @param shiftUserId the UUID of the ShiftUser to be deleted
     * @return ResponseEntity indicating success or failure of the operation
     */
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID shiftUserId){
        shiftUserService.deleteShiftUser(shiftUserId);
        return new ResponseEntity<>("Deleted Shift User Successfully", HttpStatus.OK);
    }
}
