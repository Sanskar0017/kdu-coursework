package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.RegisterUserRequest;
import com.kdu.smarthome.dto.response.RegisterUserResponse;
import com.kdu.smarthome.mapper.UserMapper;
import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repository.UsersRepository;
import com.kdu.smarthome.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling authentication-related operations.
 */
@Service
@Slf4j
public class AuthService {
    private final JWTUtil jwtUtil;
    private final UsersRepository usersRepository;

    /**
     * Constructs a new AuthService with the provided dependencies.
     *
     * @param jwtUtil           The JWT utility for token generation and validation.
     * @param usersRepository   The repository for accessing user data.
     */
    @Autowired
    public AuthService(JWTUtil jwtUtil, UsersRepository usersRepository) {
        this.jwtUtil = jwtUtil;
        this.usersRepository = usersRepository;
    }

    /**
     * Registers a new user with the provided user details.
     *
     * @param registerUserRequest   The request containing user details for registration.
     * @return                      A response indicating the success of the registration along with a generated token.
     */
    public RegisterUserResponse registerUsr(RegisterUserRequest registerUserRequest){
        log.info("Registration in process");
        Users user = UserMapper.maptoUser(registerUserRequest);
        user.setId(user.getId() + 1); // Assuming this is incrementing user ID
        usersRepository.save(user);

        log.info("Registering User");
        log.info("Generating token");

        String tokenGen = jwtUtil.createToken(registerUserRequest);
        return new RegisterUserResponse("New User Registered", tokenGen);
    }
}
