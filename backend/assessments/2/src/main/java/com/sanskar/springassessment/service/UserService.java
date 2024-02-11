/**
 * This service class provides methods to interact with user data.
 */
package com.sanskar.springassessment.service;

import com.sanskar.springassessment.dao.UserDAO;
import com.sanskar.springassessment.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to interact with user data.
 */
@Service
public class UserService {

    UserDAO userDAO;

    /**
     * Constructs a new UserService with the specified UserDAO.
     * @param userDAO the UserDAO to be used
     */
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Adds a new user.
     * @param user the user to be added
     * @return the added user
     */
    public Person addUser(Person user){
        return userDAO.addUser(user);
    }

    /**
     * Checks if a user with the given username is available.
     * @param username the username to check
     * @return true if the user is available, false otherwise
     */
    public boolean isAvailable(String username){
        return userDAO.isAvailable(username);
    }

    /**
     * Retrieves a user by username.
     * @param username the username of the user to retrieve
     * @return the user with the specified username
     */
    public Person getUser(String username) {
        return userDAO.getUser(username);
    }

    /**
     * Retrieves all users.
     * @return a list of all users
     */
    public List<Person> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
