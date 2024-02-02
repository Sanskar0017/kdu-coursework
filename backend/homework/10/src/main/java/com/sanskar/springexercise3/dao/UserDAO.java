package com.sanskar.springexercise3.dao;

import com.sanskar.springexercise3.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The UserDAO class provides access to user data.
 */
@Repository
public class UserDAO {

    /** The list of users. */
    private final List<User> userList;

    /**
     * Constructs a UserDAO with the specified list of users.
     *
     * @param userList the list of users
     */
    public UserDAO(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Checks if a user with the given username exists.
     *
     * @param username the username to check
     * @return true if the user exists, otherwise false
     */
    public boolean isAvailable(String username){
        for(User user: userList){
            if(user.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new user to the list.
     *
     * @param user the user to add
     * @return the added user
     */
    public User addUser(User user){
        userList.add(user);
        return user;
    }

    /**
     * Retrieves a user by username.
     *
     * @param username the username of the user to retrieve
     * @return the user with the specified username, or null if not found
     */
    public User getUser(String username) {
        for(User user: userList){
            if(user.getUserName().equals(username)) return user;
        }
        return null;
    }

    /**
     * Retrieves all users.
     *
     * @return the list of all users
     */
    public List<User> getAllUsers() {
        return userList;
    }
}
