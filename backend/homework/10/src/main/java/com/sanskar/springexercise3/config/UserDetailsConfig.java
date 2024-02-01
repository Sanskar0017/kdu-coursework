package com.sanskar.springexercise3.config;

import com.sanskar.springexercise3.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom UserDetailsService implementation for loading user details from the database.
 */
@Component
public class UserDetailsConfig implements UserDetailsService {

    private final UserService userService;

    /**
     * Constructor for UserDetailsConfig.
     *
     * @param userService the UserService instance
     */
    public UserDetailsConfig(UserService userService) {
        this.userService = userService;
    }

    /**
     * Loads user details by username.
     *
     * @param username the username to load user details for
     * @return UserDetails object containing user details
     * @throws UsernameNotFoundException if user details are not found for the given username
     * NOTE: com.sanskar.springexercise3.model.User -> used since, we have a similar framework in spring security
     * Using package import to resolve the issue
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.sanskar.springexercise3.model.User user = userService.getUser(username);
        String userName = null;
        String userPassword = null;
        List<GrantedAuthority> authorities = null;

        if (user == null) {
            throw new UsernameNotFoundException("User details not found for username : " + username);
        } else {
            userName = user.getUserName();
            userPassword = user.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return new User(userName, userPassword, authorities);
    }

}
