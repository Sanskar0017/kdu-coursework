package com.kdu.smarthome.services;

import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class implementing UserDetailsService for managing user authentication.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    private final UsersRepository userRepository;

    @Autowired
    public UserServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Load user details by username.
     *
     * @param username The username.
     * @return UserDetails containing user information.
     * @throws UsernameNotFoundException If the username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<String> roles = new ArrayList<>();
        roles.add("ADMIN"); // Example role, replace with actual roles from user object if available

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();
    }
}
