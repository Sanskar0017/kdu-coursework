package com.sanskar.springjdbc.controllers;

import com.sanskar.springjdbc.dto.UserDTO;
import com.sanskar.springjdbc.exceptions.RecordNotFoundException;
import com.sanskar.springjdbc.model.Users;
import com.sanskar.springjdbc.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for managing user-related endpoints.
 */
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * Constructs a new UserController with the specified UserService.
     *
     * @param userService the UserService to be injected
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to add a new user.
     *
     * @param userDTO the UserDTO representing the user to be added
     * @return a ResponseEntity indicating the result of the operation
     */
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO userDTO){
        log.info("Adding user");
        userService.addUser(userDTO);
        return new ResponseEntity<>("Successfully added user", HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve all users.
     *
     * @return a ResponseEntity containing a list of Users
     * @throws RecordNotFoundException if no users are found
     */
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Users>> getAllUser() throws RecordNotFoundException {
        log.info("Getting all users");
        List<Users> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
