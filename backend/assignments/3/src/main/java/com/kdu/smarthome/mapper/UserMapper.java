package com.kdu.smarthome.mapper;

import com.kdu.smarthome.dto.request.RegisterUserRequest;
import com.kdu.smarthome.models.Users;
import lombok.extern.slf4j.Slf4j;

/**
 * Mapper class for mapping RegisterUserRequest to Users entity.
 */
@Slf4j
public class UserMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private UserMapper() {
        // Private constructor to hide the implicit public one
    }

    /**
     * Maps a RegisterUserRequest object to a Users entity.
     *
     * @param registerUserRequest The request object to map.
     * @return The mapped Users entity.
     */
    public static Users maptoUser(RegisterUserRequest registerUserRequest) {
        log.info("Mapping to user from registerUserRequest");
        Users user = new Users();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setName(registerUserRequest.getName());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setEmailId(registerUserRequest.getEmailId());

        return user;
    }

}
