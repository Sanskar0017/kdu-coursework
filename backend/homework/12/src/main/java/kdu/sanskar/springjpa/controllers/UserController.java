package kdu.sanskar.springjpa.controllers;

import kdu.sanskar.springjpa.exceptions.RecordNotFoundException;
import kdu.sanskar.springjpa.model.Users;
import kdu.sanskar.springjpa.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class for managing user-related operations.
 */
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint for adding a new user.
     *
     * @param users The user to be added.
     * @return ResponseEntity indicating the status of the operation.
     */
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody Users users){
        log.info("Adding user");
        userService.addUser(users);
        return new ResponseEntity<>("Successfully added user", HttpStatus.OK);
    }


    /**
     * Endpoint for retrieving all users with pagination.
     *
     * @param pageNumber The page number.
     * @param pageSize   The size of the page.
     * @return Page object containing user information.
     * @throws RecordNotFoundException If no records are found.
     */
    @GetMapping("/getAllUsers")
    public Page<Users> getAllUser(@RequestParam(defaultValue = "0") int pageNumber,
                                  @RequestParam(defaultValue = "50") int pageSize) throws RecordNotFoundException {
        log.info("Getting all users using Pagination");
        return userService.getAllUsers(pageNumber, pageSize);
    }

    /**
     * Endpoint for updating user information.
     *
     * @param userID The ID of the user to be updated.
     * @param users  Updated attributes for the pre-defined userID.
     * @return ResponseEntity indicating the status of the update operation.
     */
    @PutMapping("/updater")
    public ResponseEntity<String> updateUser(@PathVariable UUID userID, @RequestParam Users users){
        log.info("Updating User");
        userService.updateUser(userID, users);
        return new ResponseEntity<>("User updated Successfully", HttpStatus.OK);
    }

}
