package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.RegisterUserRequest;
import com.kdu.smarthome.dto.response.RegisterUserResponse;
import com.kdu.smarthome.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    /**
     * Constructor for AuthController.
     *
     * @param authService The AuthService instance to handle authentication logic.
     */
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Endpoint for user registration.
     *
     * @param request The RegisterUserRequest containing user registration data.
     * @return ResponseEntity containing RegisterUserResponse with registration status.
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest request) {
        log.info("Registering New User API");
        RegisterUserResponse registerUserResponse = authService.registerUsr(request);

        return new ResponseEntity<>(registerUserResponse, HttpStatus.OK);
    }

}
