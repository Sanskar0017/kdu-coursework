package com.kdu.smarthome.config;

import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom UserDetailsService implementation for loading user details from the database.
 */
@Configuration
public class UserDetailsConfig implements UserDetailsService {

    private final UsersRepository usersRepository;



    /**
     * Constructor for UserDetailsConfig.
     *
     */
    @Autowired
    public UserDetailsConfig(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    /**
     * Loads user details by username.
     *
     * @param username the username to load user details for
     * @return UserDetails object containing user details
     * @throws UsernameNotFoundException if user details are not found for the given username
     * NOTE: com sans kar spring exercise3.model.User -> used since, we have a similar framework in spring security
     * Using package import to resolve the issue
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        String userName;
        String userPassword;
        List<GrantedAuthority> authorities;

        if (user == null) {
            throw new UsernameNotFoundException("User details not found for username : " + username);
        } else {
            userName = user.getName();
            userPassword = user.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return new User(userName, userPassword, authorities);
    }
}
