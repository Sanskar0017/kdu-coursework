package com.sanskar.springexercise3.controller;

import com.sanskar.springexercise3.model.User;
import com.sanskar.springexercise3.service.UserService;
import com.sanskar.springexercise3.exception.MyCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The UserController class handles HTTP requests related to user operations.
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Adds a new user.
     *
     * @param user The user object to add.
     * @return ResponseEntity<User> Returns the added user along with HTTP status OK.
     */
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    /**
     * Retrieves a user by username.
     *
     * @param username The username of the user to retrieve.
     * @return ResponseEntity<User> Returns the user with the specified username along with HTTP status OK.
     * @throws MyCustomException Throws an exception if the user is not found.
     */
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        try {
            log.info("Fetching user by username: {}", username);
            return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
        } catch (IndexOutOfBoundsException e) {
            log.info("User with username {}, not found", username);
            throw new MyCustomException("User with username " + username + " not found.");
        }
    }

    /**
     * Retrieves all users.
     *
     * @return ResponseEntity<List<User>> Returns a list of all users along with HTTP status OK.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("Fetching all users");
        return ResponseEntity.ok(userService.getAllUsers());
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
