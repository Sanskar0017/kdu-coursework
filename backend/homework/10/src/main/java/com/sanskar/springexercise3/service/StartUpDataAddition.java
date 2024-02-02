package com.sanskar.springexercise3.service;

import com.sanskar.springexercise3.dao.UserDAO;
import com.sanskar.springexercise3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This class initializes and adds startup data for the application.
 */
@Service
public class StartUpDataAddition implements CommandLineRunner {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs a new StartUpDataAddition instance.
     *
     * @param userDAO         the user DAO to use for adding users
     * @param passwordEncoder the password encoder to encode passwords
     */
    @Autowired
    public StartUpDataAddition(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Runs the startup data addition process.
     *
     * @param args the command line arguments (unused)
     */
    @Override
    public void run(String... args) {
        userDAO.addUser(new User("Sanskar", passwordEncoder.encode("test123"), "sanskarhere001@gmail.com", "ROLE_ADMIN"));
        userDAO.addUser(new User("Rahul", passwordEncoder.encode("rahul@123"), "rahul@gmail.com", "ROLE_USER"));
    }
}
