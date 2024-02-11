package com.sanskar.springassessment.controller;

import com.sanskar.springassessment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The UserController class handles HTTP requests related to user operations.
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
     * Handles login request for testing purposes.
     *
     * @return ResponseEntity<String> Returns a success message along with HTTP status CREATED.
     */
    @GetMapping("/person/login")
    public ResponseEntity<String> login(){
        log.info("Test login success");
        return new ResponseEntity<>("Login test Successful", HttpStatus.CREATED);
    }
}
