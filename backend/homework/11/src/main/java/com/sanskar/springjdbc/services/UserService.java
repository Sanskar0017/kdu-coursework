package com.sanskar.springjdbc.services;

import com.sanskar.springjdbc.dao.UserDAO;
import com.sanskar.springjdbc.dto.UserDTO;
import com.sanskar.springjdbc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService {

    private final UserDAO userDAO;

    /**
     * Constructs a new UserService with the specified UserDAO.
     *
     * @param userDAO the UserDAO to be used for user operations
     */
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Adds a new user.
     *
     * @param user the user DTO to be added
     */
    @Transactional
    public void addUser(UserDTO user) {
        userDAO.add(user);
    }

    /**
     * Retrieves all users.
     *
     * @return the list of all users
     */
    public List<Users> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
