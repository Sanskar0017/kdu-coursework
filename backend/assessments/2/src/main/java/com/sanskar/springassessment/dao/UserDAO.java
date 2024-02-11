package com.sanskar.springassessment.dao;

import com.sanskar.springassessment.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The UserDAO class provides access to user data.
 */
@Repository
public class UserDAO {

    /** The list of users. */
    private final List<Person> userList;

    /**
     * Constructs a UserDAO with the specified list of users.
     *
     * @param userList the list of users
     */
    public UserDAO(List<Person> userList) {
        this.userList = userList;
    }

    /**
     * Checks if a user with the given username exists.
     *
     * @param username the username to check
     * @return true if the user exists, otherwise false
     */
    public boolean isAvailable(String username){
        for(Person user: userList){
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
    public Person addUser(Person user){
        userList.add(user);
        return user;
    }

    /**
     * Retrieves a user by username.
     *
     * @param username the username of the user to retrieve
     * @return the user with the specified username, or null if not found
     */
    public Person getUser(String username) {
        for(Person user: userList){
            if(user.getUserName().equals(username)) return user;
        }
        return null;
    }

    /**
     * Retrieves all users.
     *
     * @return the list of all users
     */
    public List<Person> getAllUsers() {
        return userList;
    }
}
